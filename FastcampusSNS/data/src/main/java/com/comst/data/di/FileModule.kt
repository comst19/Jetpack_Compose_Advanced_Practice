package com.comst.data.di

import com.comst.data.usecase.file.GetImageUseCaseImpl
import com.comst.data.usecase.file.GetInputStreamUseCaseImpl
import com.comst.data.usecase.file.UploadImageUseCaseImpl
import com.comst.domain.usecase.file.GetImageUseCase
import com.comst.domain.usecase.file.GetInputStreamUseCase
import com.comst.domain.usecase.file.UploadImageUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FileModule {

    @Binds
    abstract fun bindGetInputStreamUseCase(uc : GetInputStreamUseCaseImpl): GetInputStreamUseCase

    @Binds
    abstract fun bindImageUseCase(uc : GetImageUseCaseImpl): GetImageUseCase

    @Binds
    abstract fun bindUploadImageUseCase(uc : UploadImageUseCaseImpl): UploadImageUseCase
}