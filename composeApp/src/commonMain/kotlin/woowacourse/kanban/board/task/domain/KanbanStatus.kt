package woowacourse.kanban.board.task.domain

enum class KanbanStatus(val status: String) {
    IN_PROGRESS("In Progress"),
    TO_DO("To Do"),
    DONE("Done"),
}
