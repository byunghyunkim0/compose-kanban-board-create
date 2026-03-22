package woowacourse.kanban.board.task.ui.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.task.domain.KanbanBoard
import woowacourse.kanban.board.task.domain.KanbanStatus
import woowacourse.kanban.board.task.domain.TaskMockData
import woowacourse.kanban.board.task.ui.modal.ModalCreateForm
import woowacourse.kanban.board.theme.BoardBackground

@Composable
fun KanbanBoardScreen(modifier: Modifier = Modifier) {
    var board by remember { mutableStateOf(KanbanBoard()) }

    val todoCards = remember(board) { board.getCardByStatus(KanbanStatus.TO_DO) }
    val inProgressCards = remember(board) { board.getCardByStatus(KanbanStatus.IN_PROGRESS) }
    val doneCards = remember(board) { board.getCardByStatus(KanbanStatus.DONE) }

    var isShowModal by remember { mutableStateOf(false) }

    if (isShowModal) {
        ModalCreateForm(
            assignee = TaskMockData.assignees,
            onDismissRequest = { isShowModal = false },
            onCreate = { form, status ->
                board = board.addCard(form, status)
                isShowModal = false
            },
            modifier = Modifier.width(672.dp).height(820.dp),
        )
    }

    Scaffold(
        modifier = modifier,
        containerColor = Color.White,
        topBar = {
            KanbanBoardHeader(
                modifier = Modifier.padding(
                    vertical = 16.dp,
                    horizontal = 24.dp,
                ),
                doneCount = board.doneCount,
                totalCount = board.totalCount,
                progress = board.progress,
                onCreateClick = { isShowModal = true },
            )
        },
    ) { paddingValues ->
        KanbanBody(
            todoCards = todoCards,
            inProgressCards = inProgressCards,
            doneCards = doneCards,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .background(BoardBackground)
                .padding(24.dp),
        )
    }
}

@Preview(
    widthDp = 1300,
    heightDp = 900,
)
@Composable
private fun KanbanBoardScreenPreview() {
    KanbanBoardScreen()
}
