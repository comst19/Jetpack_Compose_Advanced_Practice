package com.comst.domain.usecase.main.setting

interface SetMyUserUseCase {

    suspend operator fun invoke(
        username: String? = null,
        profileImageUrl: String? = null
    ):Result<Unit>
}