package solution.practice

class KnightWeapon {
    // https://school.programmers.co.kr/learn/courses/30/lessons/136798
    fun solution(number: Int, limit: Int, power: Int): Int {
        var result = 0

        // 기사번호는 1부터 number까지
        (1..number).forEach {
            // 약수 개수 구하기
            val measureCount = calculateMeasureCount(it)

            result += if (measureCount > limit) {
                power
            } else {
                measureCount
            }
        }

        return result
    }

    // 해당 숫자의 약수 개수 구하는 메서드
    private fun calculateMeasureCount(number: Int): Int {
        var count = 0

        for (i in 1..Math.sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) {
                // 약수는 나누어 떨어지는 수라면 2개가 있는 것이고,
                // ex) 10 / 5 = 2, 여기서 5와 2는 10의 약수 (2개)
                // 제곱한 수가 대상 수와 같다면 1개가 있는 것
                // ex) 9 / 3 = 3, 여기서 3은 9의 약수 (1개)
                count += if (i * i == number) 1 else 2
            }
        }

        return count
    }
}