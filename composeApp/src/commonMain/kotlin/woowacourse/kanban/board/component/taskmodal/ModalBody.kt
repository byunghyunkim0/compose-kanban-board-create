package woowacourse.kanban.board.component.taskmodal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.theme.AssigneeButtonBackground
import woowacourse.kanban.board.theme.BorderAssigneeButton
import woowacourse.kanban.board.theme.BorderStatusButton
import woowacourse.kanban.board.theme.StatusButtonBackground

@Composable
fun ModalBody(state: ModalCreateFormState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        ModalBodyInput(
            inputTitle = ModalBodyTextInputTitle.TITLE,
            maxLines = 1,
            validType = state.validTitle,
            state = state.title,
            onValueChange = {
                state.title = it
                state.resetTitleError()
            },
            isValid = state.validTitle == ModalErrorType.DEFAULT,
        )

        ModalBodyInput(
            inputTitle = ModalBodyTextInputTitle.CONTENT,
            maxLines = 5,
            validType = ModalErrorType.DEFAULT,
            state = state.content,
            onValueChange = {
                state.content = it
            },
            isValid = true,
        )

        ModalBodyInput(
            inputTitle = ModalBodyTextInputTitle.TAG,
            maxLines = 1,
            validType = state.validTag,
            state = state.tag,
            onValueChange = {
                state.tag = it
                state.resetTagError()
            },
            isValid = state.validTag == ModalErrorType.TAG_DEFAULT,
        )

        val stateNames = ModalBodySelectorStatus.entries.map { it.status }

        ModalBodySelector(
            selectorTitle = ModalBodySelectorTitle.STATUS,
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
                    selectedContainerColor = StatusButtonBackground,
                    selectedBorderColor = BorderStatusButton,
                )
            },
        )

        ModalBodySelector(
            selectorTitle = ModalBodySelectorTitle.ASSIGNEE,
            items = ModalMockData.assignees,
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
                    selectedContainerColor = AssigneeButtonBackground,
                    selectedBorderColor = BorderAssigneeButton,
                )
            },
        )

        ModalAction(
            isValidTitle = state.isValidTitle,
            isValidTag = state.isValidTag,
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
