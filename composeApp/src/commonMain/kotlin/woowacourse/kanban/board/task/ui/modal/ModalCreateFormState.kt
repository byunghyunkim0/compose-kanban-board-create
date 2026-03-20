package woowacourse.kanban.board.task.ui.modal

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import woowacourse.kanban.board.task.domain.TaskErrorType

class ModalCreateFormState {
    var title by mutableStateOf("")
    var content by mutableStateOf("")
    var tag by mutableStateOf("")
    var status by mutableIntStateOf(0)
    var assignee by mutableIntStateOf(0)

    var validTitle by mutableStateOf(TaskErrorType.DEFAULT)

    val isValidTitle by derivedStateOf {
        validTitle == TaskErrorType.DEFAULT
    }

    var validTag by mutableStateOf(TaskErrorType.TAG_DEFAULT)

    val isValidTag by derivedStateOf {
        validTag == TaskErrorType.TAG_DEFAULT
    }

    fun resetTitleError() {
        validTitle = TaskErrorType.DEFAULT
    }

    fun resetTagError() {
        validTag = TaskErrorType.TAG_DEFAULT
    }

    fun validate() {
        isTitleValid()
        isTagValid()
    }

    private fun isTitleValid() {
        if (title.isBlank()) {
            validTitle = TaskErrorType.TITLE_FORMAT
            return
        }
        validTitle = TaskErrorType.DEFAULT
    }

    private fun isTagValid() {
        if (tag.isEmpty()) {
            validTag = TaskErrorType.TAG_DEFAULT
            return
        }

        val tags = tag.split(",").map { it.trim() }

        if (tags.any { it.isBlank() }) {
            validTag = TaskErrorType.TAG_FORMAT
            return
        }

        if (tags.size > 5 || tags.any { it.length > 5 }) {
            validTag = TaskErrorType.TAG_SIZE
            return
        }

        validTag = TaskErrorType.TAG_DEFAULT
        return
    }
}
