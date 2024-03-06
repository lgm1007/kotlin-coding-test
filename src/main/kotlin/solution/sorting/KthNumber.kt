package solution.sorting

class KthNumber {
    // https://school.programmers.co.kr/learn/courses/30/lessons/42748
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()
        commands.forEach { ints: IntArray ->
            val subArray = array.sliceArray((ints[0] - 1) until ints[1])
            subArray.sort()
            answer.add(subArray[(ints[2] - 1)])
        }

        return answer.toIntArray()
    }
}