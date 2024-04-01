package com.comst.data.usecase

import com.comst.data.model.SignUpParam
import com.comst.data.retrofit.UserService
import com.comst.domain.usecase.login.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(
    private val userService: UserService
) : SignUpUseCase {
    override suspend fun invoke(id: String, username: String, password: String): Result<Boolean> = kotlin.runCatching {

        val requestBody = SignUpParam(
            loginId = id,
            name = username,
            password = password,
            extraUserInfo = "",
            profileFilePath = ""
        ).toRequestBody()
        userService.signUp(requestBody = requestBody).result == "SUCCESS"
    }

}