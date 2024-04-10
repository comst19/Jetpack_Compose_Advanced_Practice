package com.comst.data.usecase.file

import com.comst.data.di.BASE_URL
import com.comst.data.retrofit.FileService
import com.comst.data.retrofit.UriRequestBody
import com.comst.domain.model.Image
import com.comst.domain.usecase.file.GetInputStreamUseCase
import com.comst.domain.usecase.file.UploadImageUseCase
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadImageUseCaseImpl @Inject constructor(
    private val fileService: FileService,
    private val getInputStreamUseCase: GetInputStreamUseCase,
) : UploadImageUseCase {
    override suspend fun invoke(image: Image): Result<String> = kotlin.runCatching {
        val fileNamePart = MultipartBody.Part.createFormData(
            "fileName",
            image.name
        )
        val requestBody = UriRequestBody(
            contentUri = image.uri,
            getInputStreamUseCase = getInputStreamUseCase,
            contentType = image.mimeType.toMediaType(),
            contentLength = image.size
        )
        val filePart = MultipartBody.Part.createFormData(
            "file",
            image.name,
            requestBody
        )
        BASE_URL + fileService.uploadFile(
            fileName = fileNamePart,
            file = filePart,
        ).data.filePath
    }
}