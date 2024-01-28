package solution.kakao.internship

class MostFriendGift {
    // https://school.programmers.co.kr/learn/courses/30/lessons/258712
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        var answer: Int = 0
        // giveGiftMap = key: 선물을 준 친구, value: {key가 선물을 준 친구, 몇 번}
        val giveGiftMap: MutableMap<String, MutableMap<String, Int>> = mutableMapOf()
        // 내년에 선물을 받는 친구 Map
        val giftNextYearMap: MutableMap<String, Int> = mutableMapOf()
        // 선물 지수 Map
        val giftPointMap: MutableMap<String, Int> = mutableMapOf()
        val arrayGiveTakeCompares: MutableList<String> = mutableListOf<String>()

        // Init: map에 key로 친구 정보 우선 등록
        friends.forEach {
            giveGiftMap[it] = mutableMapOf()
            giftNextYearMap[it] = 0
        }

        // giveGiftMap 정보 세팅
        gifts.forEach {gift ->
            val splitedGift: List<String> = gift.split(" ")
            val giveFriend: String = splitedGift[0]
            val takeFriend: String = splitedGift[1]

            setupMapByGive(giveGiftMap, giveFriend, takeFriend)
        }

        // 선물 지수 Map(giftPointMap) 계산 및 세팅
        friends.forEach {friend ->
            var countAllByFriendGiveGift: Int = 0
            var countAllByFriendTakeGift: Int = 0

            // giveFriend와 takeFriend가 주고 받았던 모든 기록 계산
            gifts.forEach {gift ->
                val splitedGift: List<String> = gift.split(" ")
                val giver: String = splitedGift[0]
                val taker: String = splitedGift[1]

                if (friend == giver) {
                    countAllByFriendGiveGift++
                }
                if (friend == taker) {
                    countAllByFriendTakeGift++
                }
            }

            val giftPoint:Int = countAllByFriendGiveGift - countAllByFriendTakeGift
            giftPointMap[friend] = giftPoint
        }

        // 각 친구들끼리 받은 선물 값 계산
        for (i: Int in 0 until friends.size) {
            val giveFriend: String = friends[i]
            val takeFriendByGiveFriendMap: MutableMap<String, Int>? = giveGiftMap[giveFriend]

            for (j: Int in friends.size - 1 downTo 1) {
                // friends[i] 와 friends[j] 서로 선물 주고받은 기록 보면서 비교하기
                val takeFriend: String = friends[j]
                
                // 이미 서로 비교한 친구들인지 체크
                if(!isAlreadyCompare(arrayGiveTakeCompares, giveFriend, takeFriend)) {

                    // 서로 비교했다는 히스토리 남기기
                    arrayGiveTakeCompares.add("$giveFriend $takeFriend")

                    val takeFriendByTakeFriendMap: MutableMap<String, Int>? = giveGiftMap[takeFriend]

                    // takeFriend가 GiveFriend에게 받은 선물의 수
                    val countTakeGiftByTakeFriendToGive: Int = takeFriendByGiveFriendMap?.get(takeFriend) ?: 0
                    // giveFriend가 TakeFriend에게 받은 선물의 수
                    val countTakeGiftByGiveFriendToTake: Int = takeFriendByTakeFriendMap?.get(giveFriend) ?: 0

                    // takeFriend가 giveFriend에게 받은 선물 수가 giveFriend가 takeFriend에게 받은 선물 수보다 많은 경우 (giveFriend가 takeFriend에게 더 많은 선물을 줌)
                    // giveFriend가 takeFriend에게 내년에 선물을 하나 받는다
                    if (countTakeGiftByTakeFriendToGive > countTakeGiftByGiveFriendToTake) {
                        giftNextYearMap[giveFriend] = giftNextYearMap[giveFriend]?.plus(1) ?: 1
                    }
                    // giveFriend가 takeFriend에게 받은 선물 수가 takeFriend가 giveFriend에게 받은 선물 수보다 많은 경우 (takeFriend가 giveFriend에게 더 많은 선물을 줌)
                    // takeFriend가 giveFriend에게 내년에 선물을 하나 받는다
                    else if (countTakeGiftByGiveFriendToTake > countTakeGiftByTakeFriendToGive) {
                        giftNextYearMap[takeFriend] = giftNextYearMap[takeFriend]?.plus(1) ?: 1
                    }
                    // else: giveFriend와 takeFriend가 서로 주고받은 선물 수가 같은 경우 (주고받은 기록이 없는 경우도 포함, count 기본값 0)
                    // 선물 지수를 비교하여 선물 지수가 높은 사람이 내년에 선물을 하나 받는다
                    else {
                        val giveFriendPoint: Int = giftPointMap[giveFriend] ?: 0
                        val takeFriendPoint: Int = giftPointMap[takeFriend] ?: 0

                        if (giveFriendPoint > takeFriendPoint) {
                            giftNextYearMap[giveFriend] = giftNextYearMap[giveFriend]?.plus(1) ?: 1
                        } else if (takeFriendPoint > giveFriendPoint) {
                            giftNextYearMap[takeFriend] = giftNextYearMap[takeFriend]?.plus(1) ?: 1
                        }
                    }
                }
            }
        }

        friends.forEach {
            val countFriendNextYearGifted: Int = giftNextYearMap[it]?:0
            if (countFriendNextYearGifted > answer) {
                answer = countFriendNextYearGifted
            }
        }

        return answer
    }

    private fun setupMapByGive(
        mapByGive: MutableMap<String, MutableMap<String, Int>>,
        giveFriend: String,
        takeFriend: String
    ) {
        val giveValueMap: MutableMap<String, Int>? = mapByGive[giveFriend]
        // takeFriend가 giveFriend에게 받은 선물의 수, 값이 존재하면 + 1, 없으면 1
        val countTakeByKey: Int = giveValueMap?.get(takeFriend)?.plus(1)?:1
        giveValueMap?.put(takeFriend, countTakeByKey)
        giveValueMap?.let { mapByGive.put(giveFriend, it) }
    }

    private fun isAlreadyCompare(arrayGiveTakeCompares:MutableList<String>, giveFriend: String, takeFriend: String): Boolean {
        val comparedFriend1 = "$giveFriend $takeFriend"
        val comparedFriend2 = "$takeFriend $giveFriend"

        if (arrayGiveTakeCompares.contains(comparedFriend1)) {
            return true
        }

        if (arrayGiveTakeCompares.contains(comparedFriend2)) {
            return true
        }

        return false
    }

}