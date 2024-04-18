package com.comst.presentation.main.board

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.comst.domain.model.Comment
import com.comst.presentation.component.FCImagePager
import com.comst.presentation.main.board.comment.CommentDialog
import com.comst.presentation.ui.theme.ConnectedTheme
import com.mohamedrejeb.richeditor.model.RichTextState
import com.mohamedrejeb.richeditor.ui.BasicRichText

@Composable
fun BoardCard(
    boardId: Long,
    isMine:Boolean,
    myUserId:Long,
    profileImageUrl: String? = null,
    username: String,
    images: List<String>,
    richTextState: RichTextState,
    comments: List<Comment>,
    onOptionClick: () -> Unit,
    onDeleteComment: (Long, Comment) -> Unit,
    onPostComment: (Long, String) -> Unit
) {

    var commentDialogVisible by remember {
        mutableStateOf(false)
    }
    Surface {

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            // 헤더
            BoardHeader(
                isMine = isMine,
                modifier = Modifier.fillMaxWidth(),
                profileImageUrl = profileImageUrl,
                username = username,
                onOptionClick = onOptionClick
            )
            // 이미지 페이저
            if (images.isNotEmpty()) {
                Log.d("이미지", "$images")
                FCImagePager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    images = images
                )
            }
            var maxLines by remember(richTextState) { mutableStateOf(1) }
            var showMore by remember { mutableStateOf(false) }
            // 내용(텍스트)
            BasicRichText(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                state = richTextState,
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle.Default.copy(color = MaterialTheme.colorScheme.onPrimary),
                onTextLayout = { textLayoutResult ->
                    showMore = textLayoutResult.didOverflowHeight
                }
            )
            if (showMore) {
                TextButton(
                    onClick = {
                        maxLines = Integer.MAX_VALUE
                    }
                ) {
                    Text(
                        style = MaterialTheme.typography.labelLarge,
                        text = "더보기"
                    )
                }
            }

            // 댓글 버튼
            TextButton(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 8.dp)
                    .align(Alignment.End),
                onClick = {
                    commentDialogVisible = true
                }
            ) {
                Text(text = "${comments.size} 댓글")
            }
        }
    }

    CommentDialog(
        visible = commentDialogVisible,
        myUserId = myUserId,
        onDismissRequest = { commentDialogVisible = false },
        comments = comments,
        onDeleteComment = { comment ->
            onDeleteComment(boardId, comment)
        },
        onCloseClick = {
            commentDialogVisible = false
        },
        onPostComment = { text ->
            onPostComment(boardId, text)
        }
    )
}

@Preview
@Composable
private fun BoardCardPreview() {
    ConnectedTheme {
        BoardCard(
            isMine = false,
            myUserId = -1L,
            boardId = -1L,
            profileImageUrl = null,
            username = "Federico William",
            images = emptyList(),
            richTextState = RichTextState(),
            onOptionClick = {},
            comments = emptyList(),
            onDeleteComment = { commentId, comment ->

            },
            onPostComment = { boardId, text ->

            }
        )
    }
}