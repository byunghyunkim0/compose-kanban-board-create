package woowacourse.kanban.board.component.taskmodal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ModalCreateFormState {
    var title by mutableStateOf("")
    var content by mutableStateOf("")
    var tag by mutableStateOf("")
    var status by mutableIntStateOf(0)
    var assignee by mutableIntStateOf(0)
    fun isTagValid(): Boolean {
        val tags = tag.split(",")
        tags.forEach { if (it.isBlank()) return false }
        return true
    }
}
