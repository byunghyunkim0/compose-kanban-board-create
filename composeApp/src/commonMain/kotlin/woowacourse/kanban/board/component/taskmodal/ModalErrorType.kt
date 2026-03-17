package woowacourse.kanban.board.component.taskmodal

enum class ModalErrorType(val message: String) {
    TAG_DEFAULT("5자 이내의 태그를 최대 5개까지 등록할 수 있습니다."),
    TAG_FORMAT("태그 형식이 올바르지 않습니다."),
    TAG_SIZE("태그는 5자 이내로 5개까지만 등록할 수 있습니다."),
    TITLE_FORMAT("제목을 입력해 주세요."),
    DEFAULT(""),
}
