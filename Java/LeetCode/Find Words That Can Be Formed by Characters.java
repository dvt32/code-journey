// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

class Solution {
    
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charFrequencies = new HashMap<>();
        for (int i = 0; i < chars.length(); ++i) {
            char c = chars.charAt(i);
            charFrequencies.put(c, charFrequencies.getOrDefault(c,0)+1);
        }
        
        int lengthSum = 0;
        for (String word : words) {
            Map<Character, Integer> wordCharFrequencies = new HashMap<>();
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                wordCharFrequencies.put(c, wordCharFrequencies.getOrDefault(c,0)+1);
            }
            
            boolean isGood = true;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (!charFrequencies.containsKey(c) || charFrequencies.get(c) < wordCharFrequencies.get(c)) {
                    isGood = false;
                    break;
                }
            }
            
            if (isGood) {
                lengthSum += word.length();
            }
        }
        
        return lengthSum;
    }
    
}
