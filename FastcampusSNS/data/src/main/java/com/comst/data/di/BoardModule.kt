package com.comst.data.di

import com.comst.data.usecase.board.DeleteBoardUseCaseImpl
import com.comst.data.usecase.board.GetBoardsUseCaseImpl
import com.comst.domain.usecase.main.board.DeleteBoardUseCase
import com.comst.domain.usecase.main.board.GetBoardsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class BoardModule {

    @Binds
    abstract fun bindGetBoardsUseCase(uc : GetBoardsUseCaseImpl) : GetBoardsUseCase

    @Binds
    abstract fun bindDeleteBoardUseCase(uc : DeleteBoardUseCaseImpl) : DeleteBoardUseCase
}