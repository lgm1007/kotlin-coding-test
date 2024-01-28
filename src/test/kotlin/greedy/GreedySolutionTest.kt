package greedy

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.greedy.StolenGymClothes
import kotlin.test.assertEquals

class GreedySolutionTest {

    private val stolenGymClothes = StolenGymClothes()

    @Test
    @DisplayName("탐욕법 - 도난당한 체육복 (https://school.programmers.co.kr/learn/courses/30/lessons/42862)")
    fun stolenGymClothesTest() {
        assertEquals(5, stolenGymClothes.solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
    }
}