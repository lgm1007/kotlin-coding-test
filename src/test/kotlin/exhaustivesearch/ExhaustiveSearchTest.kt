package exhaustivesearch

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.exhaustivesearch.Carpet
import kotlin.test.assertEquals

class ExhaustiveSearchTest {
    private val carpet = Carpet()

    @Test
    @DisplayName("완전탐색 - 카펫(https://school.programmers.co.kr/learn/courses/30/lessons/42842)")
    fun carpetTest() {
        assertEquals(mutableListOf(4, 3), carpet.solution(10, 2))
    }
}