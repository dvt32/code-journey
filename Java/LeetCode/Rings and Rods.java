https://leetcode.com/problems/rings-and-rods/

class Solution {

    public int countPoints(String rings) {
        Map<Integer, Set<Character>> rodColors = new HashMap<>();

        for (int i = 0; i < rings.length()-1; i += 2) {
            char ringColor = rings.charAt(i);
            int rodNumber = Character.getNumericValue( rings.charAt(i+1) );

            Set<Character> currentRodColors = rodColors.getOrDefault(rodNumber, new HashSet<>());
            currentRodColors.add(ringColor);
            rodColors.put(rodNumber, currentRodColors);
        }

        int result = 0;
        for (Set<Character> currentRodColors : rodColors.values()) {
            if (currentRodColors.size() == 3) {
                result++;
            }
        }

        return result;
    }
    
}
