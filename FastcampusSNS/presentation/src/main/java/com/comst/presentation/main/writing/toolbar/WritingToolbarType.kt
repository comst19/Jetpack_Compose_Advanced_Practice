package com.comst.presentation.main.writing.toolbar

import androidx.annotation.DrawableRes
import com.comst.presentation.R

enum class WritingToolbarType (
    @DrawableRes val resId:Int,
){
    BOLD(R.drawable.bold),
    ITALIC(R.drawable.italic),
    UNDERLINE(R.drawable.underline),
    STRIKETHROUGH(R.drawable.strikethrough)
}