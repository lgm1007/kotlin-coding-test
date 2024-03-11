package solution.practice

class FoodFight {
    // https://school.programmers.co.kr/learn/courses/30/lessons/134240
    fun solution(food: IntArray): String {
        var answer: String = ""

        // 제일 왼쪽부터 진행
        // food[i] / 2 = i번 째 있는 음식을 나와 상대와 나눠먹기
        for (i in 1 until food.size) {
            if (food[i] / 2 != 0) {
                var repeat = 0
                while (repeat < (food[i] / 2)) {
                    answer += i.toString()
                    repeat++
                }
            } else continue
        }

        val myFood: String = answer
        answer += '0'
        // 상대방이 먹을 음식 (내가 먹은 음식 반대로)
        val opponentFood: String = myFood.reversed()

        return answer + opponentFood
    }
}