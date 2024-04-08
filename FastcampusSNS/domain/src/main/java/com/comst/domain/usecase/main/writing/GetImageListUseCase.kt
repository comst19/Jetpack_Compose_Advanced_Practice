package com.comst.domain.usecase.main.writing

import com.comst.domain.model.Image

interface GetImageListUseCase {

    suspend operator fun invoke():List<Image>
}