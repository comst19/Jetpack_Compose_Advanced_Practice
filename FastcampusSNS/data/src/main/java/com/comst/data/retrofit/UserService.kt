package com.comst.data.retrofit

import com.comst.data.model.CommonResponse
import com.comst.data.model.UserDTO
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {

    @POST("users/login")
    suspend fun login(
        @Body requestBody: RequestBody
    ):CommonResponse<String>

    @POST("users/sign-up")
    suspend fun signUp(
        @Body requestBody: RequestBody
    ):CommonResponse<Long>

    @GET("users/my-page")
    suspend fun myPage(): CommonResponse<UserDTO>
}