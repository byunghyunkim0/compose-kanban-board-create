package woowacourse.kanban.board.component

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class KanbanCardTagsTest {
    @Test
    fun `빈 태그 리스트 테스트`() = runComposeUiTest {
        val kanbanCardForm = KanbanCardForm(
            title = "LazyColumn 컴포넌트 구현",
            crewName = "다이노",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
        )

        setContent {
            KanbanCard(
                kanbanCardForm = kanbanCardForm,
            )
        }

        onNodeWithContentDescription("칸반 카드 태그 목록").assertDoesNotExist()
    }
}
