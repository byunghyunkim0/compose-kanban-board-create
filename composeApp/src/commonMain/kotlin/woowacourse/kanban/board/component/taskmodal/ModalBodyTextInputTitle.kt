package woowacourse.kanban.board.component.taskmodal

enum class ModalBodyTextInputTitle(val title: String, val essential: Boolean, val placeholder: String) {
    TITLE(
        title = "제목",
        essential = true,
        placeholder = "태스크 제목을 입력하세요",
    ),
    CONTENT(
        title = "설명",
        essential = false,
        placeholder = "태스크에 대한 자세한 설명을 입력하세요",
    ),
    TAG(
        title = "태그",
        essential = false,
        placeholder = "태그를 쉼표로 구분하여 입력하세요 (예: 버그, 긴급)",
    ),
}
