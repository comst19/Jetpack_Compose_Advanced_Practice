package com.comst.domain.model

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Image (
    val uri:String,
    val name:String,
    val size:Long,
    val mimeType:String
): Serializable
// 꼼수임 => DTO 안해서