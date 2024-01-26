package solution.greedy

class StolenGymClothes {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        lost.sort()
        reserve.sort()

        // 체육복을 잃어버렸지만 여분이 있는 학생
        val lostAndReservedCount: Int = lostAndReserveStudentCount(lost, reserve)
        // 체육복이 이미 있는 학생
        val alreadyExistCount: Int = n - (lost.size - lostAndReservedCount)
        // 체육복을 빌릴 수 있는 학생
        val reservedCount: Int = reservedStudentCount(lost, reserve)

        // 체육복이 이미 있는 학생 + 체육복을 빌릴 수 있는 학생 = 체육수업을 들을 수 있는 학생
        return alreadyExistCount + reservedCount
    }

    // 체육복을 빌림 받아 체육 수업을 들을 수 있는 학생의 수
    private fun reservedStudentCount(losts: IntArray, reserves: IntArray): Int {
        var count: Int = 0
        var tmpLosts: IntArray = losts
        var tmpReserves: IntArray = reserves

        // 여분의 체육복이 있으면서 1벌을 잃어버린 학생은 빌릴 필요가 없기 때문에 lost 배열에서 제외한다.
        // 또한 그런 학생들은 빌려줄 수도 없기 때문에 reserves에서도 제외한다.
        tmpLosts = tmpLosts.filter { !reserves.contains(it) }.toIntArray()
        tmpReserves = tmpReserves.filter { !losts.contains(it) }.toIntArray()

        for (reserve: Int in tmpReserves) {
            val frontNumber: Int = reserve - 1
            val backNumber: Int = reserve + 1

            // 빌려줄 수 있는 학생의 앞 번호 또는 뒷 번호에 있는 학생이 체육복이 없을 때 빌려주고,
            // 체육복을 받은 학생은 losts 배열에서 제외한다.
            if (tmpLosts.contains(frontNumber)) {
                count++
                tmpLosts = tmpLosts.filter { it != frontNumber }.toIntArray()
            } else if (tmpLosts.contains(backNumber)) {
                count++
                tmpLosts = tmpLosts.filter { it != backNumber }.toIntArray()
            }
        }
        return count
    }

    // 여분의 체육복이 있으면서 잃어버린 학생들 수
    private fun lostAndReserveStudentCount(losts: IntArray, reserves: IntArray): Int {
        var tmpLosts: IntArray = losts
        tmpLosts = tmpLosts.filter { reserves.contains(it) }.toIntArray()
        return tmpLosts.size
    }
}