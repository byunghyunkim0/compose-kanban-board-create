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

    var isValidTitle by mutableStateOf(true)

    var isValidTag by mutableStateOf(true)

    var errorTagMessage by mutableStateOf("5자 이내의 태그를 최대 5개까지 등록할 수 있습니다.")

    fun validate() {
        isTitleValid()
        isValidTag = isTagValid()
    }

    private fun isTitleValid() {
        isValidTitle = title.isNotBlank()
    }

    private fun isTagValid(): Boolean {
        if (tag.isEmpty()) {
            errorTagMessage = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다."
            return true
        }

        val tags = tag.split(",")
            .map {
                if (it.isBlank()) {
                    errorTagMessage = "태그 형식이 올바르지 않습니다."
                    return false
                }
                it.trim()
            }

        if (tags.size > 5) {
            errorTagMessage = "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
            return false
        }
        tags.forEach {
            if (it.length > 5) {
                errorTagMessage = "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
                return false
            }
        }
        errorTagMessage = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다."
        return true
    }
}
