package com.comst.domain.model

data class Comment (
    val id:Long,
    val userId:Long,
    val text:String,
    val username:String,
    val profileImageUrl:String? = null
)