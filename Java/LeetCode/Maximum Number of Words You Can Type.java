// https://leetcode.com/problems/maximum-number-of-words-you-can-type/

class Solution {
    
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenLettersSet = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); ++i) {
            char brokenLetter = brokenLetters.charAt(i);
            brokenLettersSet.add(brokenLetter);
        }
        
        String[] words = text.split(" ");
        int wordCount = 0;
        for (String word : words) {
            boolean canBeTyped = true;
            for (int i = 0; i < word.length(); ++i) {
                char letter = word.charAt(i);
                if (brokenLettersSet.contains(letter)) {
                    canBeTyped = false;
                    break;
                }
            }
            if (canBeTyped) {
                wordCount++;
            }
        }
        
        return wordCount;
    }
    
}
