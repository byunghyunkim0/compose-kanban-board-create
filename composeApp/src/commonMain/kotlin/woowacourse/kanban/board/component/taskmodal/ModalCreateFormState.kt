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

    var validTitle by mutableStateOf(ModalErrorType.DEFAULT)

    var validTag by mutableStateOf(ModalErrorType.TAG_DEFAULT)

    fun validate() {
        isTitleValid()
        isTagValid()
    }

    private fun isTitleValid() {
        if (title.isBlank()) {
            validTitle = ModalErrorType.TITLE_FORMAT
            return
        }
        validTitle = ModalErrorType.DEFAULT
    }

    private fun isTagValid() {
        if (tag.isEmpty()) {
            validTag = ModalErrorType.TAG_DEFAULT
            return
        }

        val tags = tag.split(",").map { it.trim() }

        if (tags.any { it.isBlank() }) {
            validTag = ModalErrorType.TAG_FORMAT
            return
        }

        if (tags.size > 5 || tags.any { it.length > 5 }) {
            validTag = ModalErrorType.TAG_SIZE
            return
        }

        validTag = ModalErrorType.TAG_DEFAULT
        return
    }
}
