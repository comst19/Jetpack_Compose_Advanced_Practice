package com.comst.domain.usecase.main.writing

import com.comst.domain.model.Image

interface PostBoardUseCase {

    suspend operator fun invoke(
        title:String,
        content:String,
        images: List<Image>
    )
}