package com.comst.presentation.main.board

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.comst.presentation.model.main.board.BoardCardModel
import com.comst.presentation.ui.theme.ConnectedTheme

@Composable
fun BoardScreen(
    boardCardModels:List<BoardCardModel>,
    onOptionClick:(BoardCardModel)->Unit,
    onReplyClick:(BoardCardModel)->Unit
) {
    Surface {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(
                count = boardCardModels.size,
                key = { index -> boardCardModels[index].boardId }
            ){  index->
                val boardCardModel = boardCardModels[index]
                BoardCard(
                    username = boardCardModel.username,
                    images = boardCardModel.images,
                    text = boardCardModel.text,
                    onOptionClick = { onOptionClick(boardCardModel) },
                    onReplyClick = {onReplyClick(boardCardModel)}
                )
            }

        }

    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BoardScreenPreview() {
    ConnectedTheme {
        BoardScreen(
            boardCardModels = listOf(
                BoardCardModel(
                    boardId = 1388, username = "Fletcher Lester", images = listOf(), text = "nihil"

                ),
                BoardCardModel(
                    boardId = 1389, username = " Lester", images = listOf(), text = "Lester"

                ),
                BoardCardModel(
                    boardId = 1390, username = "Fletcher ", images = listOf(), text = "images"

                ),
            ),
            onOptionClick = {},
            onReplyClick = {}
        )
    }
}