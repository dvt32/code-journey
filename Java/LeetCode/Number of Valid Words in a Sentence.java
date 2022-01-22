// https://leetcode.com/problems/number-of-valid-words-in-a-sentence/

class Solution {
    
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        
        int validWordCount = 0;
        for (String word : words) {
            if ( isValidWord(word) ) {
                validWordCount++;
            }
        }
            
        return validWordCount;
    }
    
    public boolean isValidWord(String word) {
        if ( word.isBlank() ) {
            return false;
        }
        
        int hyphenCount = 0;
        int punctuationMarkCount = 0;
        
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            
            boolean isValidLetter = (c >= 'a' && c <= 'z');
            boolean isValidHyphen = 
                c == '-' && 
                hyphenCount++ == 0 &&
                i != 0 && i != word.length()-1 &&
                word.charAt(i-1) >= 'a' && word.charAt(i-1) <= 'z' &&
                word.charAt(i+1) >= 'a' && word.charAt(i+1) <= 'z';
            boolean isValidPunctuationMark = 
                (c == '!' || c == '.' || c == ',') && 
                punctuationMarkCount++ == 0 &&
                i == word.length()-1;
            
            if (!isValidLetter && !isValidHyphen && !isValidPunctuationMark) { 
                return false; 
            }
        }
        
        return true;
    }
    
}
