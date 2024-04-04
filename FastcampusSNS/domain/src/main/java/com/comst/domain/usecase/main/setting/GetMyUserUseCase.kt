package com.comst.domain.usecase.main.setting

import com.comst.domain.model.User

interface GetMyUserUseCase {

    suspend operator fun invoke():Result<User>
}