package woowacourse.kanban.board.task.ui.modal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import woowacourse.kanban.board.task.domain.TaskMockData

@Composable
fun ModalCreateForm(assignee: List<String>, modifier: Modifier = Modifier) {
    val state = remember { ModalCreateFormState() }
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        ModalHeader()

        HorizontalDivider(
            thickness = Dp.Hairline,
            color = Color.LightGray,
        )

        ModalBody(
            state = state,
            assignee = assignee,
            modifier = Modifier,
        )
    }
}

@Preview(
    widthDp = 672,
    heightDp = 1000,
)
@Composable
private fun ModalCreateFormPreview() {
    ModalCreateForm(assignee = TaskMockData.assignees)
}
