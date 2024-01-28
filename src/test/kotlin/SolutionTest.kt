import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.dfsbfs.TargetNumber
import solution.greedy.StolenGymClothes
import solution.kakao.internship.MostFriendGift
import kotlin.test.assertEquals

class SolutionTest {

    private val stolenGymClothes = StolenGymClothes()
    private val targetNumber = TargetNumber()
    private val mostFriendGift = MostFriendGift()

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

    @Test
    @DisplayName("Kakao Internship - 가장 많이 받은 선물 (https://school.programmers.co.kr/learn/courses/30/lessons/258712)")
    fun mostFriendGiftTest() {
        assertEquals(4, mostFriendGift.solution(arrayOf("joy", "brad", "alessandro", "conan", "david"),
            arrayOf("alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david")))
    }
}