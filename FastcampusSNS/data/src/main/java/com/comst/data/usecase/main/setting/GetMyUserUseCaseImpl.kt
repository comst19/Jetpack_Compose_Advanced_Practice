package com.comst.data.usecase.main.setting

import com.comst.data.model.toDomainModel
import com.comst.data.retrofit.UserService
import com.comst.domain.model.User
import com.comst.domain.usecase.main.setting.GetMyUserUseCase
import javax.inject.Inject


class GetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService
) : GetMyUserUseCase {
    override suspend fun invoke(): Result<User> = kotlin.runCatching {
        userService.getMyPage().data.toDomainModel()
    }
}