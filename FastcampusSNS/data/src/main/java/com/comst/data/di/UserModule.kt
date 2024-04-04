package com.comst.data.di

import com.comst.data.usecase.ClearTokenUseCaseImpl
import com.comst.data.usecase.GetTokenUseCaseImpl
import com.comst.data.usecase.LoginUseCaseImpl
import com.comst.data.usecase.SetTokenUseCaseImpl
import com.comst.data.usecase.SignUpUseCaseImpl
import com.comst.data.usecase.main.setting.GetMyUserUseCaseImpl
import com.comst.domain.usecase.login.ClearTokenUseCase
import com.comst.domain.usecase.login.GetTokenUseCase
import com.comst.domain.usecase.login.LoginUseCase
import com.comst.domain.usecase.login.SetTokenUseCase
import com.comst.domain.usecase.login.SignUpUseCase
import com.comst.domain.usecase.main.setting.GetMyUserUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindLoginUseCase(uc:LoginUseCaseImpl):LoginUseCase

    @Binds
    abstract fun bindSignUpUseCase(uc:SignUpUseCaseImpl):SignUpUseCase

    @Binds
    abstract fun bindGetTokenUseCase(uc:GetTokenUseCaseImpl):GetTokenUseCase

    @Binds
    abstract fun bindSetTokenUseCase(uc: SetTokenUseCaseImpl):SetTokenUseCase

    @Binds
    abstract fun bindClearTokenUseCase(uc: ClearTokenUseCaseImpl):ClearTokenUseCase

    @Binds
    abstract fun bindGetMyUserUseCase(uc: GetMyUserUseCaseImpl):GetMyUserUseCase
}