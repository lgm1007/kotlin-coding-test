package solution.practice

class JadenCase {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12951
    fun solution(s: String): String {
        var answer = ""
        val toCharArr = s.toCharArray()

        for (i in 0 until toCharArr.size) {
            val c = toCharArr[i]
            if (c == ' ') {
                answer += c
            } else {
                if (i == 0) {
                    // 첫 문자 변환 시
                    // 만약 알파벳이 아닌 문자라면 그냥 입력
                    // 알파벳이라면 대문자로 변환
                    if (!isAlphabet(c)) {
                        answer += c
                    } else {
                        answer += c.toUpperCase()
                    }
                } else {
                    // 첫 문자가 아니라면, 앞전의 문자가 공백인지 확인
                    // 공백이 맞다면 해당 문자가 알파벳인지 확인
                    // 알파벳이면 대문자로 변환
                    if (answer[i - 1] == ' ') {
                        if (!isAlphabet(c)) {
                            answer += c
                        } else {
                            answer += c.toUpperCase()
                        }
                    }
                    // 앞전의 문자가 공백이 아니라면 소문자로 변환
                    else {
                        answer += c.toLowerCase()
                    }
                }
            }
        }

        return answer
    }

    private fun isAlphabet(c: Char) = c.toInt() in 65..90 || c.toInt() in 97..122
}