package codechallenge

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.codechallenge.SumNotExistNumber
import kotlin.test.assertEquals

class CodeChallengeSolutionTest {
    private val sumNotExistNumber = SumNotExistNumber()

    @Test
    @DisplayName("TipsTown - 예상 대진표(https://school.programmers.co.kr/learn/courses/30/lessons/12985)")
    fun sumNotExistNumberTest() {
        assertEquals(14, sumNotExistNumber.solution(intArrayOf(1,2,3,4,6,7,8,0)))
    }
}