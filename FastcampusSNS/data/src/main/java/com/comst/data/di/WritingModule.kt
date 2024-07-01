package com.comst.data.di

import com.comst.data.usecase.main.writing.GetImageListUseCaseImpl
import com.comst.data.usecase.main.writing.HiltWorkerPostBoardUseCase
import com.comst.data.usecase.main.writing.PostBoardUseCaseImpl
import com.comst.domain.usecase.main.writing.GetImageListUseCase
import com.comst.domain.usecase.main.writing.PostBoardUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class WritingModule {

    @Binds
    abstract fun bindGetImageListUseCase(uc : GetImageListUseCaseImpl): GetImageListUseCase

//    @Binds
//    abstract fun bindPostBoardUseCase(uc : PostBoardUseCaseImpl): PostBoardUseCase

    @Binds
    abstract fun bindPostBoardUseCase(uc : HiltWorkerPostBoardUseCase): PostBoardUseCase
}