// https://leetcode.com/problems/find-players-with-zero-or-one-losses

class Solution {

    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new TreeSet<>();
        Map<Integer, Integer> playerLosses = new TreeMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            winners.add(winner);

            int loser = match[1];
            int losses = playerLosses.getOrDefault(loser, 0);
            playerLosses.put(loser, losses+1);
        }

        List<Integer> playersWithZeroLosses = new ArrayList<>();
        for (Integer player : winners) {
            if (!playerLosses.containsKey(player)) {
                playersWithZeroLosses.add(player);
            }
        }

        List<Integer> playersWithOneLoss = new ArrayList<>();
        for (Integer player : playerLosses.keySet()) {
            if (playerLosses.get(player) == 1) {
                playersWithOneLoss.add(player);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(playersWithZeroLosses);
        answer.add(playersWithOneLoss);

        return answer;
    }

}
