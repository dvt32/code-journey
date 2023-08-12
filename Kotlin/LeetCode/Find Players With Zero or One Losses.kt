// https://leetcode.com/problems/find-players-with-zero-or-one-losses

class Solution {
    
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val winners = sortedSetOf<Int>();
        val playerLosses = sortedMapOf<Int, Int>();

        for (match in matches) {
            val winner = match[0];
            winners.add(winner);

            val loser = match[1];
            val losses = playerLosses.getOrDefault(loser, 0);
            playerLosses.put(loser, losses+1);
        }

        val playersWithZeroLosses = mutableListOf<Int>();
        for (player in winners) {
            if (!playerLosses.containsKey(player)) {
                playersWithZeroLosses.add(player);
            }
        }

        val playersWithOneLoss = mutableListOf<Int>();
        for (player in playerLosses.keys) {
            if (playerLosses.get(player) == 1) {
                playersWithOneLoss.add(player);
            }
        }

        val answer = mutableListOf(playersWithZeroLosses, playersWithOneLoss)

        return answer;
    }

}
