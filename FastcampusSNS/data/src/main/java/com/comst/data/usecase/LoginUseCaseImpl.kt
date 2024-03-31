package com.comst.data.usecase

import com.comst.data.model.LoginParam
import com.comst.data.retrofit.UserService
import com.comst.domain.usecase.login.LoginUseCase
import javax.inject.Inject


class LoginUseCaseImpl @Inject constructor(
    private val userService: UserService
) : LoginUseCase{
    override suspend fun invoke(id: String, password: String): Result<String> = kotlin.runCatching {

        val requestBody = LoginParam(loginId = id, password = password).toRequestBody()
        userService.login(requestBody = requestBody).data
    }
}