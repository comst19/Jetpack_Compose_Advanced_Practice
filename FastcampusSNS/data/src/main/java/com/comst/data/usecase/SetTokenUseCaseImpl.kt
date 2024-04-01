package com.comst.data.usecase

import com.comst.data.UserDataStore
import com.comst.domain.usecase.login.SetTokenUseCase
import javax.inject.Inject

class SetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : SetTokenUseCase {

    override suspend fun invoke(token: String) {
        userDataStore.setToken(token)
    }

}