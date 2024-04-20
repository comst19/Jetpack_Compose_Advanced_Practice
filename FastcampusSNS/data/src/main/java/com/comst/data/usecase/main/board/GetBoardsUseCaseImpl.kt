package com.comst.data.usecase.main.board

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.comst.data.database.BoardDatabase
import com.comst.data.database.BoardRemoteMediator
import com.comst.data.model.toDomainModel
import com.comst.data.retrofit.BoardService
import com.comst.domain.model.Board
import com.comst.domain.usecase.main.board.GetBoardsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Provider

class GetBoardsUseCaseImpl @Inject constructor(
    //private val pagingSource: Provider<BoardPagingSource>,
    private val boardDatabase: BoardDatabase,
    private val mediator: BoardRemoteMediator
) : GetBoardsUseCase {
    @OptIn(ExperimentalPagingApi::class)
    override suspend fun invoke(): Result<Flow<PagingData<Board>>> = kotlin.runCatching {
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            remoteMediator = mediator,
            pagingSourceFactory = {
                boardDatabase.BoardDao().getAll()
            }
        ).flow.map { pagingData ->
            pagingData.map { it.toDomainModel() }
        }
    }

}