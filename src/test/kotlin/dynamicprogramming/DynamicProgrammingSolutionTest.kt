package dynamicprogramming

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.dynamicprogramming.JumpAway
import kotlin.test.assertEquals

class DynamicProgrammingSolutionTest {
    private val jumpAway = JumpAway()

    @Test
    @DisplayName("동적 프로그래밍 - 멀리 뛰기(https://school.programmers.co.kr/learn/courses/30/lessons/12914)")
    fun jumpAwayTest() {
        assertEquals(8, jumpAway.solution(5))
    }
}