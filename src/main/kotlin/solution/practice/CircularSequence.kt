package solution.practice

class CircularSequence {
    fun solution(elements: IntArray): Int {
        // 수열의 합을 넣어 줄 hash
        // answer = 합을 넣어 준 hash 내 요소의 개수
        val resultHashSet: MutableSet<Int> = mutableSetOf()
        var sliceCount = 1
        val mutableElements = elements.toMutableList()

        while (sliceCount <= elements.size) {
            for (i in 0 until mutableElements.size) {
                val endOffset = i + sliceCount - 1
                resultHashSet.add(makeSlicedSum(mutableElements, endOffset, i, sliceCount))
            }

            sliceCount++
        }

        return resultHashSet.size
    }

    private fun makeSlicedSum(mutableElements: MutableList<Int>,
                            endOffset: Int,
                            index: Int,
                            sliceCount: Int): Int {
        // endOffset이 배열 길이 이상이 되어버린 경우
        return if (endOffset >= mutableElements.size) {
            val sliceds = mutableElements.slice(index until mutableElements.size).toMutableList()
            var j = 0

            // sliceds가 sliceCount와 크기가 같아질 때까지 0부터 순차적으로 sliceds에 add
            while (sliceds.size < sliceCount) {
                sliceds.add(mutableElements[j])
                j++
            }

            sliceds.sum()
        } else {
            mutableElements.slice(index..endOffset)
                .sum()
        }
    }
}