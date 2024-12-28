// https://leetcode.com/problems/count-the-number-of-special-characters-ii/

class Solution {

    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> lowercaseLastIndices = new HashMap<>();
        Map<Character, Integer> uppercaseFirstIndices = new HashMap<>();

        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lowercaseLastIndices.put(c, i);
            } else {
                uppercaseFirstIndices.putIfAbsent(c, i);
            }
        }

        int specialCount = 0;
        for (Map.Entry<Character, Integer> entry : lowercaseLastIndices.entrySet()) {
            Character uppercaseKey = Character.toUpperCase(entry.getKey());
            if (uppercaseFirstIndices.getOrDefault(uppercaseKey, -1) > entry.getValue()) {
                specialCount++;
            }
        }

        return specialCount;
    }

}
