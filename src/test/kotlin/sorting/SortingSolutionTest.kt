package sorting

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.sorting.BiggestNumber
import kotlin.test.assertEquals

class SortingSolutionTest {
    private val biggestNumber = BiggestNumber()

    @Test
    @DisplayName("정렬 - 가장 큰 수(https://school.programmers.co.kr/learn/courses/30/lessons/42746)")
    fun biggestNumberTest() {
        assertEquals("9534330", biggestNumber.solution(intArrayOf(3, 30, 34, 5, 9)))
    }
}