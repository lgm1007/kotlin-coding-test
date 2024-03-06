package sorting

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.sorting.*
import kotlin.test.assertEquals

class SortingSolutionTest {
    private val biggestNumber = BiggestNumber()
    private val kthNumber = KthNumber()

    @Test
    @DisplayName("정렬 - 가장 큰 수(https://school.programmers.co.kr/learn/courses/30/lessons/42746)")
    fun biggestNumberTest() {
        assertEquals("9534330", biggestNumber.solution(intArrayOf(3, 30, 34, 5, 9)))
    }

    @Test
    @DisplayName("정렬 - K번째수(https://school.programmers.co.kr/learn/courses/30/lessons/42748)")
    fun kthNumberTest() {
        assertEquals(intArrayOf(5, 6, 3), kthNumber.solution(intArrayOf(1, 5, 2, 6, 3, 7, 4),
            arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
        ))
    }
}