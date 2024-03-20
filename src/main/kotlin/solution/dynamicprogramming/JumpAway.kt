package solution.dynamicprogramming

class JumpAway {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12914
    fun solution(n: Int): Int {
        // 정답은 1, 2, 3, 5, 8, ... 이렇게 추가되는 수열
        // dp로 해결
        if (n == 0) {
            return 0
        }

        if (n == 1) {
            return 1
        }

        if (n == 2) {
            return 2
        }

        val dp = mutableListOf(0, 1, 2)
        for(i in 3 until n + 1) {
            dp.add((dp[i - 1] + dp[i - 2]) % 1234567)
        }

        return dp[n]
    }
}