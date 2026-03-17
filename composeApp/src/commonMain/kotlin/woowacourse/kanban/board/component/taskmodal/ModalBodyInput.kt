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
    inputTitle: ModalBodyTextInputTitle,
    maxLines: Int,
    validType: ModalErrorType,
    state: String,
    isValid: Boolean,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth(),
    ) {
        ModalInputTitle(
            title = inputTitle.title,
            essential = inputTitle.essential,
        )

        ModalInputField(
            value = state,
            onValueChange = onValueChange,
            isValid = isValid,
            placeHolder = inputTitle.placeholder,
            maxLines = maxLines,
            supportingText = validType.message,
        )
    }
}

@Preview
@Composable
private fun ModalBodyInputPreview() {
    val inputTitle = ModalBodyTextInputTitle.TITLE
    Box(
        modifier = Modifier.padding(10.dp),
    ) {
        var state by remember { mutableStateOf("") }
        ModalBodyInput(
            inputTitle = inputTitle,
            maxLines = 1,
            validType = ModalErrorType.TITLE_FORMAT,
            state = state,
            onValueChange = {
                state = it
            },
            isValid = false,
        )
    }
}
