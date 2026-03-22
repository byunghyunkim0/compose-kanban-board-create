package woowacourse.kanban.board.task.domain

data class KanbanBoard(var cards: List<KanbanCard> = emptyList(), var cardId: Long = 0) {
    val progress: Int
        get() {
            if (cards.isEmpty()) return 0
            val count = cards.count { it.status == KanbanStatus.DONE }
            return (count * 100) / cards.size
        }

    fun getCardByStatus(status: KanbanStatus) = cards.filter { it.status == status }

    fun addCard(kanbanCardForm: KanbanCardForm, status: KanbanStatus) {
        val card = KanbanCard(
            id = ++cardId,
            title = kanbanCardForm.title,
            content = kanbanCardForm.content,
            tags = kanbanCardForm.tags,
            status = status,
            assigneeName = kanbanCardForm.crewName
        )

        cards = cards + card
    }
}
