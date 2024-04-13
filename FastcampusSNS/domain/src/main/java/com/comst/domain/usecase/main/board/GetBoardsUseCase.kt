package com.comst.domain.usecase.main.board

import androidx.paging.PagingData
import com.comst.domain.model.Board
import kotlinx.coroutines.flow.Flow

interface GetBoardsUseCase {

    suspend operator fun invoke():Result<Flow<PagingData<Board>>>
}