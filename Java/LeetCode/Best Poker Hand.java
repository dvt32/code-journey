// https://leetcode.com/problems/best-poker-hand/

class Solution {

    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> uniqueSuits = new HashSet<>();

        for (char suit : suits) {
            uniqueSuits.add(suit);
        }
        if (uniqueSuits.size() == 1) {
            return "Flush";
        }

        Map<Integer, Integer> rankCounts = new HashMap<>();
        boolean foundTwo = false;
        
        for (int rank : ranks) {
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        for (Integer rankCount : rankCounts.values()) {
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
