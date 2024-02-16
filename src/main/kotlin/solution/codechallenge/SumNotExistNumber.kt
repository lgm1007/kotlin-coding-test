package solution.codechallenge

class SumNotExistNumber {
    // https://school.programmers.co.kr/learn/courses/30/lessons/86051
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0

        // 0부터 9까지 정수 배열 생성
        val tmp: IntArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

        // 0부터 9까지의 정수 중 numbers에 포함되지 않는 값들을 더함
        tmp.forEach {
            if (!numbers.contains(it)) {
                answer += it
            }
        }

        return answer
    }
}