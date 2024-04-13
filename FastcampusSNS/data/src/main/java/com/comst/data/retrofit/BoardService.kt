package com.comst.data.retrofit

import com.comst.data.model.BoardDTO
import com.comst.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BoardService {

    @POST("boards")
    suspend fun postBoard(
        @Body requestBody: RequestBody
    ):CommonResponse<Long>

    @GET("boards")
    suspend fun getBoards(
        @Query("page") page:Int,
        @Query("size") size:Int
    ):CommonResponse<List<BoardDTO>>

}