package stackqueue

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.stackqueue.FunctionDevelop
import kotlin.test.assertEquals

class StackQueueSolutionTest {
    private val functionDevelop = FunctionDevelop()

    @Test
    @DisplayName("스택/큐 - 기능개발(https://school.programmers.co.kr/learn/courses/30/lessons/42586)")
    fun functionDevelopTest() {
        assertEquals(mutableListOf(2, 1), functionDevelop.solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)))
    }
}