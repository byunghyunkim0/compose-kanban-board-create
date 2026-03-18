package woowacourse.kanban.board.component.taskmodal

enum class ModalBodySelectorTitle(val title: String, val essential: Boolean) {
    STATUS(
        title = "상태",
        essential = true,
    ),
    ASSIGNEE(
        title = "담당자",
        essential = true,
    ),
}
