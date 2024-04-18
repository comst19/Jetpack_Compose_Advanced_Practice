package com.comst.presentation.main.writing

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import com.comst.domain.model.Image
import com.comst.domain.usecase.main.writing.GetImageListUseCase
import com.comst.domain.usecase.main.writing.PostBoardUseCase
import com.mohamedrejeb.richeditor.model.RichTextState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class WritingViewModel @Inject constructor(
    private val getImageListUseCase: GetImageListUseCase,
    private val postBoardUseCase: PostBoardUseCase
) : ViewModel(),
    ContainerHost<WritingState, WritingSideEffect> {
    override val container: Container<WritingState, WritingSideEffect> = container(
        initialState = WritingState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent { postSideEffect(WritingSideEffect.Toast(throwable.message.orEmpty())) }
            }
        }
    )

    init {
        load()
    }

    private fun load() = intent {
        val images = getImageListUseCase()
        reduce {
            state.copy(
                selectedImages = images.firstOrNull()?.let { listOf(it) } ?: emptyList(),
                images = images
            )
        }
    }

    fun onItemClick(image: Image) = intent {
        reduce {
            if (state.selectedImages.contains(image)) {
                state.copy(
                    selectedImages = state.selectedImages - image
                )
            } else {
                state.copy(
                    selectedImages = state.selectedImages + image
                )
            }

        }
    }

    fun onPostClick() = intent {
        postBoardUseCase(
            title = "제목 없음",
            content = state.richTextState.toHtml(),
            images = state.selectedImages
        )
        postSideEffect(WritingSideEffect.Finish)
    }
}

@Immutable
data class WritingState(
    val selectedImages: List<Image> = emptyList(),
    val images: List<Image> = emptyList(),
    val richTextState: RichTextState = RichTextState()
)

sealed interface WritingSideEffect {
    class Toast(val message: String) : WritingSideEffect
    object Finish : WritingSideEffect
}