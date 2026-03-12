package woowacourse.kanban.board.component.taskmodal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ModalBody(modifier: Modifier = Modifier) {
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
            supportingText = "",
        )

        ModalBodyInput(
            title = "설명",
            essential = false,
            placeHolder = "태스크에 대한 자세한 설명을 입력하세요",
            maxLines = 5,
            supportingText = "",
        )

        ModalBodyInput(
            title = "태그",
            essential = false,
            placeHolder = "태그를 쉼표로 구분하여 입력하세요 (예: 버그, 긴급)",
            maxLines = 1,
            supportingText = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다.",
        )

        val stateNames = listOf("In Progress", "To Do", "Done")
        ModalBodySelector(
            title = "상태",
            essential = true,
            items = stateNames,
            content = @Composable { name ->
                ModalOptionButton(
                    onClick = {},
                    modifier = Modifier,
                    content = {
                        ModalOptionStatus(
                            modifier = Modifier,
                            text = name,
                        )
                    },
                )
            },
        )

        val assigneeNames = listOf("커비", "바드", "다이노", "아오", "하로")
        ModalBodySelector(
            title = "담당자",
            essential = true,
            items = assigneeNames,
            content = @Composable { name ->
                ModalOptionButton(
                    onClick = {},
                    modifier = Modifier,
                    content = {
                        ModalOptionAssignee(
                            modifier = Modifier,
                            name = name,
                        )
                    },
                )
            },
        )

        ModalAction()
    }
}

@Preview(widthDp = 672, heightDp = 820)
@Composable
private fun ModalBodyPreview() {
    ModalBody()
}
