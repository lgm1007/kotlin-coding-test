package solution.practice

class YearningScore {
    // https://school.programmers.co.kr/learn/courses/30/lessons/176963
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): MutableList<Int> {
        val answer: MutableList<Int> = mutableListOf<Int>()
        // 그리워하는 인물, 추억 점수를 묶은 Map
        val yearningMap: MutableMap<String, Int> = mutableMapOf()

        // Map<인물 이름, 추억 점수> 세팅
        for (i: Int in 0 until name.size) {
            val nameOfYearning: String = name[i]
            val score: Int = yearning[i]

            yearningMap[nameOfYearning] = score
        }

        // photo 이중 배열을 탐색하면서 추억 점수 계산
        photo.forEach {nameInPhotoes ->
            var photoYearningScore: Int = 0
            nameInPhotoes.forEach {
                // 사진 속 인물 중 name 배열에 없는 이름, 즉 Map에 없는 인물은 추억 점수 0점
                photoYearningScore += yearningMap[it]?:0
            }
            answer.add(photoYearningScore)
        }

        return answer
    }
}