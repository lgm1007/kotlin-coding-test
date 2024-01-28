package kakao.internship

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.kakao.internship.MostFriendGift
import kotlin.test.assertEquals

class KakaoInternshipSolutionTest {

    private val mostFriendGift = MostFriendGift()

    @Test
    @DisplayName("Kakao Internship - 가장 많이 받은 선물 (https://school.programmers.co.kr/learn/courses/30/lessons/258712)")
    fun mostFriendGiftTest() {
        assertEquals(4, mostFriendGift.solution(arrayOf("joy", "brad", "alessandro", "conan", "david"),
            arrayOf("alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david")))
    }
}