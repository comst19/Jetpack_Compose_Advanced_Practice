package com.comst.data.database

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.comst.data.model.BoardDTO
import com.comst.data.retrofit.BoardService
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class BoardRemoteMediator @Inject constructor(
    private val database: BoardDatabase,
    private val boardService: BoardService
): RemoteMediator<Int, BoardDTO>() {

    val remoteKeyDao = database.remoteKeyDao()
    val boardDao = database.BoardDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BoardDTO>
    ): MediatorResult {
        val remoteKey = when(loadType){
            LoadType.REFRESH->{null}
            LoadType.PREPEND->{return  MediatorResult.Success(true)}
            LoadType.APPEND->{ remoteKeyDao.getNextKey()}
        }
        try {
            val page = remoteKey?.nextPage?:1
            val loadSize = 10
            val response = boardService.getBoards(
                page = page,
                size = loadSize
            )
            val boardList = response.data
            database.withTransaction {
                if (loadType == LoadType.REFRESH){
                    boardDao.deleteAll()
                    remoteKeyDao.deleteAll()
                }
                remoteKeyDao.insertOrReplace(RemoteKey(nextPage = page + 1))
                boardDao.insertAll(boardList)
            }
            // 페이지 끝에 도달
            return MediatorResult.Success(loadSize != boardList.size)
        }catch (e:Exception){
            return MediatorResult.Error(e)
        }

    }
}