// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/

class Solution {
    
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> charFrequencies = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);
        }
        
        int expectedNumberOfOccurrences = charFrequencies.get(s.charAt(0));
        for (Integer numberOfOccurrences : charFrequencies.values()) {
            if (numberOfOccurrences != expectedNumberOfOccurrences) {
                return false;
            }
        }
        
        return true;
    }
    
}
