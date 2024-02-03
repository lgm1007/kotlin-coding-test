package practice

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.practice.BlindPhoneNumber
import solution.practice.YearningScore
import kotlin.test.assertEquals

class PracticeTest {

    private val yearningScore = YearningScore()
    private val blindPhoneNumber = BlindPhoneNumber()

    @Test
    @DisplayName("연습문제 - 추억 점수(https://school.programmers.co.kr/learn/courses/30/lessons/176963)")
    fun yearningScoreTest() {
        assertEquals(
            mutableListOf(67, 0, 55) , yearningScore.solution(arrayOf("kali", "mari", "don"), intArrayOf(11, 1, 55),
            arrayOf(arrayOf("kali", "mari", "don"), arrayOf("pony", "tom", "teddy"), arrayOf("con", "mona", "don"))
        ))
    }

    @Test
    @DisplayName("연습문제 - 핸드폰 번호 가리기(https://school.programmers.co.kr/learn/courses/30/lessons/12948)")
    fun blindPhoneNumberTest() {
        assertEquals("*******2222", blindPhoneNumber.solution("01033332222"))
    }
}