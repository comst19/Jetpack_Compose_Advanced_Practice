package com.comst.domain.usecase.file

import com.comst.domain.model.Image

interface GetImageUseCase {

    operator fun invoke(contentUri:String): Image?
}