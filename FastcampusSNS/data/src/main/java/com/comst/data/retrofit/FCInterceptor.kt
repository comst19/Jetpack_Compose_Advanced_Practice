package com.comst.data.retrofit

import android.util.Log
import com.comst.data.UserDataStore
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class FCInterceptor @Inject constructor(
    private val userDataStore: UserDataStore
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token:String? = runBlocking { userDataStore.getToken() }
        Log.d("토큰",token.toString())
        return chain.proceed(
            chain.request()
                .newBuilder()
                .run {
                    if (token.isNullOrEmpty()){
                        this
                    }else{
                        this.addHeader("Token", token)
                    }
                }
                .addHeader("Content-Type","application/json; charset=UTF8")
                .build()
        )
    }
}