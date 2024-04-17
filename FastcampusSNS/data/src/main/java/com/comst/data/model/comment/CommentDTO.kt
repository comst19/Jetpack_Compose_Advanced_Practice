package com.comst.data.model.comment

import com.comst.domain.model.Comment
import kotlinx.serialization.Serializable

@Serializable
data class CommentDTO(
    val id: Long,
    val comment: String,
    val createdAt: String,
    val createUserId: Long,
    val createUserName: String,
    val profileImageUrl: String
)

fun CommentDTO.toDomainModel(): Comment{
    return Comment(
        id = id,
        userId = createUserId,
        text = comment,
        username = createUserName,
        profileImageUrl = profileImageUrl
    )
}