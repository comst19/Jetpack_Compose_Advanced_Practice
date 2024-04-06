package com.comst.data.retrofit

import android.util.Log
import com.comst.domain.usecase.file.GetInputStreamUseCase
import okhttp3.MediaType
import okhttp3.RequestBody
import okio.BufferedSink
import okio.FileNotFoundException
import okio.source

class UriRequestBody constructor(
    val contentUri:String,
    val getInputStreamUseCase: GetInputStreamUseCase,
    val contentType:MediaType? = null,
    val contentLength:Long
) : RequestBody() {
    override fun contentType(): MediaType? {
        return contentType
    }

    override fun contentLength(): Long {
        return contentLength
    }

    override fun writeTo(sink: BufferedSink) {
        try {
            getInputStreamUseCase(contentUri).getOrThrow()
                .use { inputStream ->
                    sink.writeAll(inputStream.source())
                }
        }catch (e : FileNotFoundException){
            Log.e("UriRequestBody", e.message.orEmpty())
        }

    }
}