import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.dfsbfs.TargetNumber
import solution.greedy.StolenGymClothes
import kotlin.test.assertEquals

class SolutionTest {

    private val stolenGymClothes = StolenGymClothes()
    private val targetNumber = TargetNumber()

    @Test
    @DisplayName("탐욕법 - 도난당한 체육복 (https://school.programmers.co.kr/learn/courses/30/lessons/42862)")
    fun stolenGymClothesTest() {
        assertEquals(5, stolenGymClothes.solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
    }

    @Test
    @DisplayName("DFS/BFS - 타겟 넘버 (https://school.programmers.co.kr/learn/courses/30/lessons/43165)")
    fun targetNumberTest() {
        assertEquals(5, targetNumber.solution(intArrayOf(1, 1, 1, 1, 1), 3))
    }
}