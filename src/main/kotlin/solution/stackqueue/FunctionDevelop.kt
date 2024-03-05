package solution.stackqueue

class FunctionDevelop {
    // https://school.programmers.co.kr/learn/courses/30/lessons/42586
    fun solution(progresses: IntArray, speeds: IntArray): MutableList<Int> {
        val answer: MutableList<Int> = mutableListOf()
        val progressList: ArrayList<Int> = ArrayList()
        // 일자가 지나면서 작업 진행도를 저장할 리스트
        val dayOffProgress: ArrayList<Int> = ArrayList()

        progresses.forEach {
            progressList.add(it)
        }

        var doneIndex: Int = 0
        var deployNum: Int = 0

        // 반복할 때마다 일자가 지난다고 생각
        while (doneIndex < progressList.size) {
            dayOffProgress.clear()

            for (i: Int in 0 until progressList.size) {
                // 일 수가 지날 때마다 진행도 + 작업 속도
                progressList[i] = progressList[i] + speeds[i]
                dayOffProgress.add(progressList[i])
            }

            for (i: Int in doneIndex until dayOffProgress.size) {
                if (dayOffProgress[doneIndex] < 100) break
                doneIndex++
                deployNum++
            }

            // 일자가 지나면서 한 번이라도 배포가 이루어졌다면 answer에 추가
            // 배포 수 0 초기화
            if (deployNum > 0) {
                answer.add(deployNum)
                deployNum = 0
            }
        }

        return answer
    }
}