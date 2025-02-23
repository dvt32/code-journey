// https://leetcode.com/problems/best-poker-hand/

class Solution {

    fun bestHand(ranks: IntArray, suits: CharArray): String {
        val uniqueSuits = mutableSetOf<Char>();

        for (suit in suits) {
            uniqueSuits.add(suit);
        }
        if (uniqueSuits.size == 1) {
            return "Flush";
        }

        val rankCounts = mutableMapOf<Int, Int>();
        var foundTwo = false;
        
        for (rank in ranks) {
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        for (rankCount in rankCounts.values) {
            if (rankCount >= 3) {
                return "Three of a Kind";
            } else if (rankCount == 2) {
                foundTwo = true;
            }
        }
        if (foundTwo) {
            return "Pair";
        }

        return "High Card";
    }

}
