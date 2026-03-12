package woowacourse.kanban.board.component.taskmodal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ModalBodyInput(
    title: String,
    essential: Boolean,
    placeHolder: String,
    maxLines: Int,
    supportingText: String,
    state: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth(),
    ) {
        ModalInputTitle(
            title = title,
            essential = essential,
        )

        ModalInputField(
            value = state,
            onValueChange = onValueChange,
            error = false,
            placeHolder = placeHolder,
            maxLines = maxLines,
            supportingText = supportingText,
        )
    }
}

@Preview
@Composable
private fun ModalBodyInputPreview() {
    Box(
        modifier = Modifier.padding(10.dp),
    ) {
        var state by remember { mutableStateOf("") }
        ModalBodyInput(
            title = "제목",
            essential = true,
            placeHolder = "태스크 제목을 입력하세요",
            maxLines = 1,
            supportingText = "서폿팅 텍스트 입니다.",
            state = state,
            onValueChange = {
                state = it
            },
        )
    }
}
