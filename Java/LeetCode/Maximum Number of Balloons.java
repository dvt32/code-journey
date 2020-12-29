// https://leetcode.com/problems/maximum-number-of-balloons/

class Solution {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> charFrequencies = new HashMap<>();
        
        for (int i = 0; i < text.length(); ++i) {
            char currentChar = text.charAt(i);
            charFrequencies.put(
                currentChar, 
                charFrequencies.getOrDefault(currentChar, 0) + 1
            );
        }
        
        char[] wordLetters = { 'b', 'a', 'l', 'o', 'n' };
        int minWordLetterFrequencies = Integer.MAX_VALUE;
        for (int i = 0; i < wordLetters.length; ++i) {
            char currentLetter = wordLetters[i];
            
            if (currentLetter == 'l' || currentLetter == 'o') {
                minWordLetterFrequencies = Math.min( minWordLetterFrequencies, charFrequencies.getOrDefault(currentLetter, 0) / 2 );
            }
            else {
                minWordLetterFrequencies = Math.min( minWordLetterFrequencies, charFrequencies.getOrDefault(currentLetter, 0) );
            }
        }
        
        return minWordLetterFrequencies;
    }
    
}
