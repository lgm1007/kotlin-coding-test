package solution.practice

class BlindPhoneNumber {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12948
    fun solution(phoneNumber: String): String {
        val phoneNumberChars: CharArray = phoneNumber.toCharArray()
        for (i: Int in 0 until phoneNumberChars.size - 4) {
            phoneNumberChars[i] = '*'
        }

        return String(phoneNumberChars)
    }
}