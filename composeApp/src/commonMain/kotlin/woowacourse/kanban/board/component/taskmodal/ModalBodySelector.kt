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
import woowacourse.kanban.board.theme.AssigneeButtonBackground
import woowacourse.kanban.board.theme.BorderAssigneeButton
import woowacourse.kanban.board.theme.BorderStatusButton
import woowacourse.kanban.board.theme.StatusButtonBackground

@Composable
fun ModalBodySelector(
    selectorTitle: ModalBodySelectorTitle,
    modifier: Modifier = Modifier,
    items: List<String>,
    content: @Composable (item: String, id: Int) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ModalInputTitle(
            title = selectorTitle.title,
            essential = selectorTitle.essential,
        )

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

    val selectorTitle = ModalBodySelectorTitle.STATUS
    val status = ModalBodySelectorStatus.entries.map { it.status }

    ModalBodySelector(
        selectorTitle = selectorTitle,
        items = status,
        content = @Composable { name, id ->
            ModalOptionButton(
                onClick = {
                    selectedId = id
                },
                modifier = Modifier,
                content = {
                    ModalOptionStatus(
                        modifier = Modifier,
                        text = name,
                    )
                },
                isSelected = selectedId == id,
                selectedContainerColor = StatusButtonBackground,
                selectedBorderColor = BorderStatusButton,
            )
        },
    )
}

@Preview
@Composable
private fun ModalOptionAssigneePreview() {
    var selectedId by remember { mutableIntStateOf(0) }
    val selectorTitle = ModalBodySelectorTitle.ASSIGNEE

    ModalBodySelector(
        selectorTitle = selectorTitle,
        items = ModalMockData.assignees,
        content = @Composable { name, id ->
            ModalOptionButton(
                onClick = {
                    selectedId = id
                },
                content = {
                    ModalOptionAssignee(
                        modifier = Modifier,
                        name = name,
                    )
                },
                isSelected = selectedId == id,
                selectedContainerColor = AssigneeButtonBackground,
                selectedBorderColor = BorderAssigneeButton,
            )
        },
    )
}
