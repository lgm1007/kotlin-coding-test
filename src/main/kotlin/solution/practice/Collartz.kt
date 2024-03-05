package solution.practice

class Collartz {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12943
    fun solution(num: Int): Int {
        var answer = 0
        var tmpNum: Long = num.toLong()

        while (tmpNum != 1L) {
            if (answer >= 500) return -1

            if (tmpNum % 2L == 0.toLong()) {
                tmpNum /= 2L
            } else {
                tmpNum = (tmpNum * 3) + 1
            }

            answer++
        }

        return answer
    }
}