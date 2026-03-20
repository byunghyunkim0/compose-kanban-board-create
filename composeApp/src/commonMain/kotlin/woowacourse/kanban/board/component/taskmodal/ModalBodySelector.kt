package woowacourse.kanban.board.component.taskmodal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.label_assignee
import kanbanboard.composeapp.generated.resources.label_status
import org.jetbrains.compose.resources.stringResource
import woowacourse.kanban.board.theme.AssigneeButtonBackground
import woowacourse.kanban.board.theme.BorderAssigneeButton
import woowacourse.kanban.board.theme.BorderStatusButton
import woowacourse.kanban.board.theme.StatusButtonBackground

@Composable
fun ModalBodySelector(
    title: String,
    items: List<String>,
    modifier: Modifier = Modifier,
    content: @Composable (item: String, id: Int) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ModalInputTitle(title)

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            itemsIndexed(
                items,
            ) { index, item ->
                content(
                    item,
                    index,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ModalBodySelectorOptionPreview() {
    var selectedId by remember { mutableIntStateOf(0) }

    val status = ModalBodySelectorStatus.entries.map { it.status }

    ModalBodySelector(
        title = stringResource(Res.string.label_status),
        items = status,
    ) { name, id ->
        ModalOptionButton(
            onClick = {
                selectedId = id
            },
            modifier = Modifier,
            isSelected = selectedId == id,
            selectedContainerColor = StatusButtonBackground,
            selectedBorderColor = BorderStatusButton,
        ) {
            ModalOptionStatus(
                modifier = Modifier,
                text = name,
            )
        }
    }
}

@Preview
@Composable
private fun ModalOptionAssigneePreview() {
    var selectedId by remember { mutableIntStateOf(0) }

    ModalBodySelector(
        title = stringResource(Res.string.label_assignee),
        items = ModalMockData.assignees,
    ) { name, id ->
        ModalOptionButton(
            onClick = {
                selectedId = id
            },
            isSelected = selectedId == id,
            selectedContainerColor = AssigneeButtonBackground,
            selectedBorderColor = BorderAssigneeButton,
        ) {
            ModalOptionAssignee(
                modifier = Modifier,
                name = name,
            )
        }
    }
}
