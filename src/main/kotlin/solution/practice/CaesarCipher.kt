package solution.practice

class CaesarCipher {
    fun solution(s: String, n: Int): String {
        // https://school.programmers.co.kr/learn/courses/30/lessons/12926
        var answer: String = ""

        s.toCharArray().forEach {
            // 공백인 경우에는 그냥 공백
            if (' '.equals(it)) {
                answer += " "
            }
            // 문자가 대문자인 경우
            if (it.toInt() in 65..90) {
                // 90 (대문자 Z)를 넘어가면 -26을 해줘 다시 A부터 더해지도록 한다.
                val moveAsciiNum: Int = getUpperCaseMoveAsciiNum(it, n)
                answer += moveAsciiNum.toChar()
            }
            // 문자가 소문자인 경우
            if (it.toInt() in 97 .. 122) {
                // 122 (소문자 z)를 넘어가면 -26을 해줘 다시 a부터 더해지도록 한다.
                val moveAsciiNum: Int = getLowerCaseMoveAsciiNum(it, n)
                answer += moveAsciiNum.toChar()
            }
        }

        return answer;
    }

    private fun getUpperCaseMoveAsciiNum(it: Char, n: Int): Int {
        return if (it.toInt() + n > 90) it.toInt() + n - 26
        else it.toInt() + n
    }

    private fun getLowerCaseMoveAsciiNum(it: Char, n: Int): Int {
        return if (it.toInt() + n > 122) it.toInt() + n - 26
        else it.toInt() + n
    }
}