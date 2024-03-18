package solution.greedy

import java.util.*

class MakeBiggestNumber {
    // https://school.programmers.co.kr/learn/courses/30/lessons/42883
    fun solution(number: String, k: Int): String {
        val numberStack: Stack<Int> = Stack()
        var count = k
        var answer = ""

        for (i in 0 until (number.length)) {

            val c: Char = number[i]
            val numByChar: Int = Character.getNumericValue(c)

            if (i < (number.length - 1)) {
                val nextChar: Char = number[i + 1]
                val numByNextChar: Int = Character.getNumericValue(nextChar)

                // 인덱스 순서대로 숫자 하나씩 스택에 push
                numberStack.push(numByChar)

                while (!numberStack.empty()) {
                    // 다음 순서의 숫자가 최근 스택에 추가한 숫자보다 작거나 같을 때 또는
                    // k (= count) 값이 0보다 작거나 같을 때는 반복 중지
                    if (numByNextChar <= numberStack.peek() || count <= 0) {
                        break
                    }
                    // 위 조건이 아닌 경우에는 다음 순서의 숫자가 최근 스택에 들어간 숫자보다 크다는 것이므로
                    // 스택에서 최근 값 pop
                    // k--
                    numberStack.pop()
                    count--
                }
            } else {
                numberStack.push(numByChar)
            }

        }

        // count > 0: k만큼 분할을 아직 하지 않은 경우
        // = count-- 할 조건이 많이 나오지 않은 경우
        // = 스택에 입력값 number 순으로 추가된 경우가 많은 것
        if (count > 0) {
            // 스택에서 0부터 스택 크기 - 1 - count 만큼 slice 한 다음 순차적으로 answer에 추가
            val slicedList: List<Int> = numberStack.slice(0..(numberStack.size - 1 - count))

            for(item in slicedList) {
                answer += item.toString()
            }
        } else {
            // else: 스택 안에 가장 큰 숫자가 만들어져 있는 상태
            // 스택에서 순차적으로 pop하면서 숫자를 만들되, 스택에 가장 최근에 추가된 값이 가장 낮은 자리 수
            // 따라서 가장 나중에 pop한 값이 가장 좌측으로 배치되게끔 추가한다.
            while (!numberStack.empty()) {
                val item: Int = numberStack.pop()
                answer = item.toString() + answer
            }
        }

        return answer
    }
}