package woowacourse.kanban.board.task.domain

data class KanbanBoard(val cards: List<KanbanCard> = emptyList(), val progress: Int = 0, val cardId: Long = 0) {
    fun getCardByStatus(status: KanbanStatus): List<KanbanStatus> {
        return emptyList()
    }

    fun addCard(kanbanCardForm: KanbanCardForm, status: KanbanStatus) {
    }
}
