package com.comst.data.usecase.main.setting

import com.comst.data.model.UpdateMyInfoParam
import com.comst.data.retrofit.UserService
import com.comst.domain.usecase.main.setting.GetMyUserUseCase
import com.comst.domain.usecase.main.setting.SetMyUserUseCase
import javax.inject.Inject

class SetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService,
    private val getMyUserUseCase: GetMyUserUseCase
) : SetMyUserUseCase {
    override suspend fun invoke(
        username: String?,
        profileImageUrl:String?
    ): Result<Unit> = kotlin.runCatching{
        val user = getMyUserUseCase().getOrThrow()
        val requestBody = UpdateMyInfoParam(
            userName = username?:user.username,
            profileFilePath = profileImageUrl?:user.profileImageUrl.orEmpty(),
            extraUserInfo = ""
        ).toRequestBody()
        userService.patchMyPage(requestBody)
    }
}