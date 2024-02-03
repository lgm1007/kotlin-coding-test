package solution.tipstown

class TournamentMatch {
    fun solution(n: Int, a: Int, b: Int): Int {
        // a = (a / 2) + (a % 2)
        // b = (b / 2) + (b % 2)
        // a == b 가 되는 차례를 구하면 되지 않을까?
        var tmpA: Int = a
        var tmpB: Int = b
        var answer = 1

        while (tmpA != tmpB) {
            tmpA = (tmpA / 2) + (tmpA % 2)
            tmpB = (tmpB / 2) + (tmpB % 2)

            if (tmpA == tmpB) break;
            answer++
        }

        return answer
    }
}