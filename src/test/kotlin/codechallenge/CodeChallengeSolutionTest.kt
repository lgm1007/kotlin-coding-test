package codechallenge

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.codechallenge.InnerProduct
import solution.codechallenge.InsufficientMoney
import solution.codechallenge.SumNotExistNumber
import kotlin.test.assertEquals

class CodeChallengeSolutionTest {
    private val sumNotExistNumber = SumNotExistNumber()
    private val innerProduct = InnerProduct()
    private val insufficientMoney = InsufficientMoney()

    @Test
    @DisplayName("TipsTown - 예상 대진표(https://school.programmers.co.kr/learn/courses/30/lessons/12985)")
    fun sumNotExistNumberTest() {
        assertEquals(14, sumNotExistNumber.solution(intArrayOf(1,2,3,4,6,7,8,0)))
    }

    @Test
    @DisplayName("월간 코드 챌린지 - 내적(https://school.programmers.co.kr/learn/courses/30/lessons/70128)")
    fun innerProductTest() {
        assertEquals(3, innerProduct.solution(intArrayOf(1, 2, 3, 4), intArrayOf(-3, -1, 0, 2)))
    }

    @Test
    @DisplayName("위클리 챌린지 - 부족한 금액 계산하기(https://school.programmers.co.kr/learn/courses/30/lessons/82612)")
    fun insufficientMoneyTest() {
        assertEquals(10, insufficientMoney.solution(3, 20, 4))
    }
}