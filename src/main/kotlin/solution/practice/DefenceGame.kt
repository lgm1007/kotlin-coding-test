package solution.practice

import java.util.PriorityQueue

class DefenceGame {
    // https://school.programmers.co.kr/learn/courses/30/lessons/142085
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        // 라운드 수
        var round: Int = 0
        var passedCount: Int = k
        var soldierCount: Int = n

        // 그리디하게 풀어야 할 듯
        // 우선순위 큐에는 무적권을 사용하여 처리한 적의 수를 저장
        val priorityQueue: PriorityQueue<Int> = PriorityQueue<Int>()

        for (e: Int in enemy) {
            if (passedCount > 0) {
                // 무적권이 남아있다면 일단 사용
                priorityQueue.offer(e)
                passedCount--
            } else {
                // 무적권을 다 사용했다면
                // 무적권을 사용해 처리한 적 수 중 가장 적은 수와 현재 라운드의 적 수를 비교

                var lessThanCout: Int = e

                if (e > priorityQueue.peek()) {
                    // 현재 라운드의 적이 더 많다면 현재 적에게 무적권을 사용하고 이전의 적은 병사로 처리
                    lessThanCout = priorityQueue.poll()
                    priorityQueue.offer(e)
                }

                if (soldierCount >= lessThanCout) {
                    // 남아있는 병사 수가 처리할 적 수를 처리할 수 있다면 처리할 적 수만큼 차감하고 다음 라운드 진행
                    soldierCount -= lessThanCout
                } else break
            }

            round++
        }

        return round
    }
}