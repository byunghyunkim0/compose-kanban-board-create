package woowacourse.kanban.board.component.taskmodal

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.awt.SystemColor.text

@Composable
fun ModalOptionButton(modifier: Modifier = Modifier, onClick: () -> Unit, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .width(200.dp)
            .height(52.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .border(1.5.dp, Color.Blue, RoundedCornerShape(10.dp))
            .clickable(enabled = true, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Preview
@Composable
private fun ModalOptionButtonPreview() {
    var enabled by remember { mutableStateOf(false) }
    ModalOptionButton(
        modifier = Modifier, onClick = {},
        content = {
            ModalOptionStatus(
                modifier = Modifier,
                text = "In Progress",
            )
        },
    )
}

@Preview
@Composable
private fun ModalOptionAssigneePreview() {
    var enabled by remember { mutableStateOf(false) }
    ModalOptionButton(
        modifier = Modifier, onClick = {},
        content = {
            ModalOptionAssignee(
                modifier = Modifier,
                name = "다이노",
            )
        },
    )
}

@Composable
fun ModalOptionStatus(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
    )
}

@Composable
fun ModalOptionAssignee(modifier: Modifier = Modifier, name: String) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "담당자 아이콘",
            tint = Color.Gray,
        )

        Text(
            text = name,
            fontSize = 14.sp,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
