package woowacourse.kanban.board.component.taskmodal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@Composable
fun ModalCreateForm(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        ModalHeader()

        HorizontalDivider(thickness = Dp.Hairline, color = Color.LightGray)

        ModalBody()
    }
}

@Preview(widthDp = 672, heightDp = 820)
@Composable
private fun ModalCreateFormPreview() {
    ModalCreateForm()
}
