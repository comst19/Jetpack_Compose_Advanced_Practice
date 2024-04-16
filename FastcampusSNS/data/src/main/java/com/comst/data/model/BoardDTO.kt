package com.comst.data.model

import com.comst.data.model.comment.CommentDTO
import com.comst.data.model.comment.toDomainModel
import com.comst.domain.model.Board
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class BoardDTO(

    val id: Long,
    val title: String,
    val content: String,
    val createdAt: String,
    val updatedAt: String,
    val createUserId: Long,
    val createUserName: String,
    val createUserProfileFilePath: String,
    val commentList:List<CommentDTO>
)

fun BoardDTO.toDomainModel(): Board {
    val contentParam = Json.decodeFromString<ContentParam>(content)
    return Board(
        id = this.id,
        title = this.title,
        content = contentParam.text,
        images = contentParam.images,
        username = this.createUserName,
        profileImageUrl = this.createUserProfileFilePath,
        comments = this.commentList.map { it.toDomainModel() }
    )
}