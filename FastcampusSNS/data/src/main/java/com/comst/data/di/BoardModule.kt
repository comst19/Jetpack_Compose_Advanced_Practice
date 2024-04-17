package com.comst.data.di

import com.comst.data.usecase.main.board.DeleteBoardUseCaseImpl
import com.comst.data.usecase.main.board.DeleteCommentUseCaseImpl
import com.comst.data.usecase.main.board.GetBoardsUseCaseImpl
import com.comst.data.usecase.main.board.PostCommentUseCaseImpl
import com.comst.domain.usecase.main.board.DeleteBoardUseCase
import com.comst.domain.usecase.main.board.DeleteCommentUseCase
import com.comst.domain.usecase.main.board.GetBoardsUseCase
import com.comst.domain.usecase.main.board.PostCommentUseCase
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

    @Binds
    abstract fun bindPostCommentUseCase(uc : PostCommentUseCaseImpl) : PostCommentUseCase

    @Binds
    abstract fun bindDeleteCommentUseCase(uc : DeleteCommentUseCaseImpl) : DeleteCommentUseCase
}