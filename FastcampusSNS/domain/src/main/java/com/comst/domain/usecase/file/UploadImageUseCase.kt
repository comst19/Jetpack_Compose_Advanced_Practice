package com.comst.domain.usecase.file

import com.comst.domain.model.Image

interface UploadImageUseCase {
    suspend operator fun invoke(
        image: Image
    ):Result<String>
}