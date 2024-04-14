package com.comst.presentation.main.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.comst.presentation.model.main.board.BoardCardModel
import com.comst.presentation.ui.theme.ConnectedTheme

@Composable
fun BoardOptionDialog(
    model: BoardCardModel?,
    onDismissRequest: () -> Unit,
    onBoardDelete: (BoardCardModel) -> Unit
) {
    model?.run {
        Dialog(onDismissRequest = onDismissRequest) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextButton(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    onClick = {
                        onBoardDelete(this@run)
                        onDismissRequest()
                    },
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Text(
                        text = "삭제"
                    )
                }
            }
        }
    }

}

@Preview
@Composable
private fun BoardOptionDialogPreview() {
    ConnectedTheme {
        var visible by remember {
            mutableStateOf(true)
        }
        BoardOptionDialog(
            model = null,
            onDismissRequest = {
                visible = false
            },
            onBoardDelete = {}
        )
    }
}