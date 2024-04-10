package com.comst.data.usecase.main.writing

import android.content.Context
import android.content.Intent
import com.comst.data.model.BoardParcel
import com.comst.data.service.PostingService
import com.comst.domain.model.Image
import com.comst.domain.usecase.main.writing.PostBoardUseCase
import javax.inject.Inject

class PostBoardUseCaseImpl @Inject constructor(
    private val context: Context
): PostBoardUseCase {

    override suspend fun invoke(title: String, content: String, images: List<Image>) {
        val board = BoardParcel(title= title, content= content, images = images)
        context.startForegroundService(
            Intent(
                context,
                PostingService::class.java
            ).apply {
                putExtra(PostingService.EXTRA_BOARD, board)
            }
        )
    }

}