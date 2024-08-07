package com.comst.data.database

import androidx.room.TypeConverter
import com.comst.data.model.comment.CommentDTO
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CommentConverter {

    @TypeConverter
    fun fromCommentListJson(commentList: List<CommentDTO>):String{
        return Json.encodeToString(commentList)
    }

    @TypeConverter
    fun fromJsonToCommentList(json: String):List<CommentDTO>{
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromCommentToJson(comment:CommentDTO):String{
        return Json.encodeToString(comment)
    }

    @TypeConverter
    fun fromJsonToComment(json: String):CommentDTO{
        return Json.decodeFromString(json)
    }
}