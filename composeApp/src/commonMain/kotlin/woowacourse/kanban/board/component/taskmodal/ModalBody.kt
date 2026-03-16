package woowacourse.kanban.board.component.taskmodal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ModalBody(state: ModalCreateFormState, modifier: Modifier = Modifier) {
    val titleMessage = if (state.isValidTitle) "" else "제목을 입력해주세요."
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        ModalBodyInput(
            title = "제목",
            essential = true,
            placeHolder = "태스크 제목을 입력하세요",
            maxLines = 1,
            supportingText = titleMessage,
            state = state.title,
            onValueChange = {
                state.title = it
            },
            isValid = state.isValidTitle,
        )

        ModalBodyInput(
            title = "설명",
            essential = false,
            placeHolder = "태스크에 대한 자세한 설명을 입력하세요",
            maxLines = 5,
            supportingText = "",
            state = state.content,
            onValueChange = {
                state.content = it
            },
            isValid = true,
        )

        ModalBodyInput(
            title = "태그",
            essential = false,
            placeHolder = "태그를 쉼표로 구분하여 입력하세요 (예: 버그, 긴급)",
            maxLines = 1,
            supportingText = state.errorTagMessage,
            state = state.tag,
            onValueChange = {
                state.tag = it
            },
            isValid = state.isValidTag,
        )

        val stateNames = listOf(
            "To Do",
            "In Progress",
            "Done",
        )
        ModalBodySelector(
            title = "상태",
            essential = true,
            items = stateNames,
            content = @Composable { name, id ->
                ModalOptionButton(
                    modifier = Modifier.height(52.dp),
                    onClick = { state.status = id },
                    content = {
                        ModalOptionStatus(
                            modifier = Modifier,
                            text = name,
                        )
                    },
                    isSelected = state.status == id,
                    selectedContainerColor = Color(0xFFEFF6FF),
                    selectedBorderColor = Color(0xFF1447E6),
                )
            },
        )

        val assigneeNames = listOf(
            "커비",
            "바드",
            "다이노",
            "아오",
            "하로",
        )
        ModalBodySelector(
            title = "담당자",
            essential = true,
            items = assigneeNames,
            content = @Composable { name, id ->
                ModalOptionButton(
                    modifier = Modifier.height(68.dp),
                    onClick = {
                        state.assignee = id
                    },
                    content = {
                        ModalOptionAssignee(
                            modifier = Modifier,
                            name = name,
                        )
                    },
                    isSelected = state.assignee == id,
                    selectedContainerColor = Color(0xFFEFF6FF),
                    selectedBorderColor = Color(0xFF615FFF),
                )
            },
        )

        ModalAction(
            onClick = { state.validate() },
        )
    }
}

@Preview(
    widthDp = 672,
    heightDp = 820,
)
@Composable
private fun ModalBodyPreview() {
    var state = remember { ModalCreateFormState() }
    ModalBody(
        state = state,
    )
}
