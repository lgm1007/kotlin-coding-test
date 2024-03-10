package practice

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.practice.*
import kotlin.test.assertEquals

class PracticeTest {

    private val yearningScore = YearningScore()
    private val blindPhoneNumber = BlindPhoneNumber()
    private val defenceGame = DefenceGame()
    private val caesarCipher = CaesarCipher()
    private val trioProblem = TrioProblem()
    private val collartz = Collartz()
    private val jadenCase = JadenCase()

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

    @Test
    @DisplayName("연습문제 - 디펜스 게임(https://school.programmers.co.kr/learn/courses/30/lessons/142085)")
    fun defenceGameTest() {
        assertEquals(5, defenceGame.solution(7, 3, intArrayOf(4, 2, 4, 5, 3, 3, 1)))
    }

    @Test
    @DisplayName("연습문제 - 시저 암호(https://school.programmers.co.kr/learn/courses/30/lessons/12926)")
    fun caesarCipherTest() {
        assertEquals("e F d", caesarCipher.solution("a B z", 4))
    }

    @Test
    @DisplayName("연습문제 - 삼총사(https://school.programmers.co.kr/learn/courses/30/lessons/131705)")
    fun trioProblemTest() {
        assertEquals(5, trioProblem.solution(intArrayOf(-3, -2, -1, 0, 1, 2, 3)))
    }

    @Test
    @DisplayName("연습문제 - 콜라츠 추측(https://school.programmers.co.kr/learn/courses/30/lessons/12943)")
    fun collartzTest() {
        assertEquals(8, collartz.solution(6))
    }

    @Test
    @DisplayName("연습문제 - JadenCase 문자열 만들기(https://school.programmers.co.kr/learn/courses/30/lessons/12951)")
    fun jadenCaseTest() {
        assertEquals("3people Unfollowed Me", jadenCase.solution("3people unFollowed me"))
    }
}