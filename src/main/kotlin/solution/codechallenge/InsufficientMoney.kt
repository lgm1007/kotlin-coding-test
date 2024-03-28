package solution.codechallenge

class InsufficientMoney {
    // https://school.programmers.co.kr/learn/courses/30/lessons/82612
    fun solution(price: Int, money: Int, count: Int): Long {
        var totalPrice = 0L

        for(i: Int in 1..count) {
            totalPrice += (price.toLong() * (i.toLong()))
        }

        if (money.toLong() >= totalPrice) {
            return 0
        }

        return totalPrice - money.toLong()
    }
}