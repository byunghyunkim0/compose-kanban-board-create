package woowacourse.kanban.board.component.taskmodal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ModalBodySelector(
    title: String,
    essential: Boolean,
    modifier: Modifier = Modifier,
    items: List<String>,
    content: @Composable (item: String) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ModalInputTitle(
            title = title,
            essential = essential,
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(
                items,
            ) { item ->
                content(item)
            }
        }
    }
}

@Preview
@Composable
private fun ModalBodySelectorOptionPreview() {
    val names = listOf(
        "In Progress",
        "To Do",
        "Done",
    )
    val contents = names.map {
        @Composable {
            ModalOptionButton(
                modifier = Modifier,
                onClick = {},
                content = {
                    ModalOptionStatus(
                        modifier = Modifier,
                        text = it,
                    )
                },
            )
        }
    }

    ModalBodySelector(
        title = "상태",
        essential = true,
        items = names,
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
}

@Preview
@Composable
private fun ModalOptionAssigneePreview() {
    val names = listOf(
        "커비",
        "바드",
        "다이노",
        "아오",
        "하로",
    )
    ModalBodySelector(
        title = "담당자",
        essential = true,
        items = names,
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
}
