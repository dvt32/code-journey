// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

class Solution {
    
    public int mostWordsFound(String[] sentences) {
        int maxNumberOfWords = 0;
        
        for (String sentence : sentences) {
            maxNumberOfWords = Math.max(maxNumberOfWords, sentence.split(" ").length);
        }
        
        return maxNumberOfWords;
    }
    
}
