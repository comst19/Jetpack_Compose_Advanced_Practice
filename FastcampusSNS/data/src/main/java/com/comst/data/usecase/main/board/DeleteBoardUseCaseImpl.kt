package com.comst.data.usecase.main.board

import com.comst.data.retrofit.BoardService
import com.comst.domain.usecase.main.board.DeleteBoardUseCase
import javax.inject.Inject

class DeleteBoardUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : DeleteBoardUseCase {
    override suspend fun invoke(boardId: Long): Result<Long> = kotlin.runCatching {
        boardService.deleteBoard(id = boardId).data
    }

}