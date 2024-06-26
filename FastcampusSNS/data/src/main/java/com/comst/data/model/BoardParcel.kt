package com.comst.data.model

import android.os.Parcelable
import com.comst.domain.model.Image
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class BoardParcel(
    val title: String,
    val content: String,
    val images:List<Image>
) : Parcelable
