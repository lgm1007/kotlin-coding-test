package solution.sorting

class BiggestNumber {
    // https://school.programmers.co.kr/learn/courses/30/lessons/42746
    fun solution(numbers: IntArray): String {
        var answer = ""
        val strNumbers = mutableListOf<String>()
        // 숫자를 문자열로 변경해 strNumbers에 add
        numbers.forEach {
            strNumbers.add(it.toString())
        }

        val compareSortedWith = CompareSortedWith()

        val sortedStrNumbers = strNumbers.sortedWith(compareSortedWith)

        run breaker@ {
            sortedStrNumbers.forEach {
                answer += it
                if (answer == "0") return@breaker
            }
        }

        return answer
    }
}

class CompareSortedWith: Comparator<String> {
    // Comparator 설명: 연속된 비교 대상 문자열을 가져와 하나는 s1 + s2, 다른 하나는 s2 + s1으로 이어붙인다.
    // 이어붙인 문자열을 Integer로 변환 후 서로 비교한다.
    // 비교할 때 내림차순으로 정렬되도록 i2를 비교 기준, i1을 비교할 타깃으로 잡는다.
    override fun compare(s1: String, s2: String): Int {
        val i1 = (s1 + s2).toInt()
        val i2 = (s2 + s1).toInt()

        return i2.compareTo(i1)
    }
}