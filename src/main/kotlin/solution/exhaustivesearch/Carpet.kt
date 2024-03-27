package solution.exhaustivesearch

class Carpet {
    // https://school.programmers.co.kr/learn/courses/30/lessons/42842
    fun solution(brown: Int, yellow: Int): MutableList<Int> {

        val resultArr = mutableListOf<Int>()

        // 위 또는 아래 brown 한 줄 개수: yellow의 column 칸 수 + 2
        // yellow 가 있는 양 옆 brown 개수: yellow의 row 한 줄 길이 * 2

        // yellow의 column 칸 수 = yellow 가 약수로 나뉘어 진 몫
        // yellow의 row 한 줄 길이 = yellow 가 나눠지는 수 (약수)

        // 총 brown 수 = (yellow 가 나뉘어진 몫 + 2) * 2 + (yellow 약수 * 2)
        // 단, yellow의 약수는 몫보다 크지 않은 값으로만 탐색한다.

        for (i: Int in 1..yellow) {
            // i가 yellow의 약수이면
            if (yellow % i == 0) {
                // 약수가 몫보다 크지 않은지 체크
                val share = yellow / i
                if (i > share) {
                    break
                }

                if ((((share + 2) * 2) + (i * 2)) == brown) {
                    // 전체 크기
                    // 전체 column 칸 수: yellow의 column 칸 수 + 2
                    // 전체 row 줄 수: yellow의 row 줄 수 + 2
                    resultArr.add(share + 2)
                    resultArr.add(i + 2)
                    break
                }
            }
        }
        return resultArr
    }
}