package com.comst.data.usecase.main.board

import com.comst.data.model.comment.CommentParam
import com.comst.data.retrofit.BoardService
import com.comst.domain.usecase.main.board.PostCommentUseCase
import javax.inject.Inject

class PostCommentUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : PostCommentUseCase {
    override suspend fun invoke(boardId: Long, text: String): Result<Long> = kotlin.runCatching {
        val requestBody = CommentParam(text).toRequestBody()
        boardService.postComment(
            boardId = boardId,
            requestBody = requestBody
        ).data
    }
}