package com.comst.presentation.model.main.board

import androidx.compose.runtime.Immutable
import com.comst.domain.model.Board
import com.comst.domain.model.Comment
import com.mohamedrejeb.richeditor.model.RichTextState

@Immutable
data class BoardCardModel(
    val userId:Long,
    val boardId:Long,
    val username:String,
    val images:List<String>,
    val richTextState: RichTextState,
    val comments:List<Comment>
)

fun Board.toUIModel():BoardCardModel{
    return BoardCardModel(
        userId = this.userId,
        boardId = this.id,
        username = this.username,
        images = this.images,
        richTextState = RichTextState().apply { setHtml(this@toUIModel.content) },
        comments = this.comments
    )
}
