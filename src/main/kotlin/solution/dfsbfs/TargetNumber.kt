package solution.dfsbfs

import java.util.*

class TargetNumber {
    // https://school.programmers.co.kr/learn/courses/30/lessons/43165
    fun solution(numbers: IntArray, target: Int): Int {
        return bfs(numbers, target);
    }

    // bfs 방식으로 풀이
    fun bfs(numbers: IntArray, target: Int): Int {
        var answer: Int = 0
        val queue: Queue<Node> = LinkedList()
        queue.add(Node(0, numbers[0]))
        queue.add(Node(0, numbers[0] * -1))

        while (!queue.isEmpty()) {
            val node: Node = queue.poll()

            // 인덱스가 numbers의 맨 끝까지 도달했을 때 sum을 타겟과 비교해보고 같으면 answer 값을 카운트한다.
            if (node.index == numbers.size - 1) {
                if (node.sum == target) {
                    answer++
                }
                continue
            }

            // next 인덱스 값
            val nextIndex: Int = node.index + 1

            // next 인덱스 값이 numbers 범위를 넘어가는 것을 방지하기 위한 처리
            if (nextIndex == numbers.size) {
                continue
            }

            // numbers 정수들을 더하고 뺀 값(* -1 한 값)을 지닌 노드를 큐에 add
            queue.add(Node(nextIndex, node.sum + numbers[nextIndex]))
            queue.add(Node(nextIndex, node.sum + (numbers[nextIndex] * -1)))
        }

        return answer
    }

    // index = numbers의 인덱스를 나타내는 값
    // sum = numbers에서 position 만큼 탐색하면서 가져온 값들의 합
    class Node(index: Int, sum: Int) {
        var index: Int = 0
        var sum: Int = 0
        init {
            this.index = index
            this.sum = sum
        }
    }
}