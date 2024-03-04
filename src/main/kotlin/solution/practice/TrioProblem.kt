package solution.practice

class TrioProblem {
    // https://school.programmers.co.kr/learn/courses/30/lessons/131705
    fun solution(number: IntArray): Int {
        var answer: Int = 0
        for (i: Int in 0 until number.size) {
            if ((i + 1) > number.size)
                break
            for (j: Int in i + 1 until number.size) {
                if ((j + 1) > number.size)
                    break
                for (k: Int in j + 1 until number.size) {
                    if (number[i] + number[j] + number[k] == 0)
                        answer++
                }
            }
        }
        return answer
    }
}