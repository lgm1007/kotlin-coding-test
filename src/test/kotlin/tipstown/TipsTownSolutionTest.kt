package tipstown

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import solution.tipstown.TournamentMatch
import kotlin.test.assertEquals

class TipsTownSolutionTest {
    private val tournamentMatch = TournamentMatch()

    @Test
    @DisplayName("TipsTown - 예상 대진표(https://school.programmers.co.kr/learn/courses/30/lessons/12985)")
    fun tournamentMatchTest() {
        assertEquals(3, tournamentMatch.solution(8, 4, 7))
    }
}