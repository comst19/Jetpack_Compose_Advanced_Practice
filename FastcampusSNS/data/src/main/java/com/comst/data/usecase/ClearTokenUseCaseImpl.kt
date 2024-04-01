package com.comst.data.usecase

import com.comst.data.UserDataStore
import com.comst.domain.usecase.login.ClearTokenUseCase
import javax.inject.Inject

class ClearTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : ClearTokenUseCase {
    override suspend fun invoke() {
        userDataStore.clear()
    }
}