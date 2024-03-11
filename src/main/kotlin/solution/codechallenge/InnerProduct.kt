package solution.codechallenge

class InnerProduct {
    // https://school.programmers.co.kr/learn/courses/30/lessons/70128
    fun solution(a: IntArray, b: IntArray): Int {
        var answer: Long = 0L

        for (i in a.indices) {
            answer += (a[i] * b[i])
        }

        return answer.toInt()
    }
}