package com.comst.assistedinjection

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class GetUserInfoUseCase @AssistedInject constructor(
    @Assisted val userNo: Long,
    val userService: UserService
) {

    fun getUser(): User {
        // 네트워크 콜
        return User()
    }
}

@AssistedFactory
interface GetUserInfoUseCaseFactory{
    fun create(userNo:Long): GetUserInfoUseCase
}