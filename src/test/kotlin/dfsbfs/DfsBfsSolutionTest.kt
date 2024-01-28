package dfsbfs

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.dfsbfs.TargetNumber
import kotlin.test.assertEquals

class DfsBfsSolutionTest {

    private val targetNumber = TargetNumber()

    @Test
    @DisplayName("DFS/BFS - 타겟 넘버 (https://school.programmers.co.kr/learn/courses/30/lessons/43165)")
    fun targetNumberTest() {
        assertEquals(5, targetNumber.solution(intArrayOf(1, 1, 1, 1, 1), 3))
    }
}