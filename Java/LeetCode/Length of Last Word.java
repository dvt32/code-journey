// https://leetcode.com/problems/length-of-last-word

class Solution {
    
    public int lengthOfLastWord(String s) {
        int lastWordLength = 0;
        
        if (!s.isEmpty() && !s.contains(" ")) {
            lastWordLength = s.length();
            return lastWordLength;
        }
        
        String[] words = s.split(" ");
        for (int i = words.length-1; i >= 0; --i) {
            String word = words[i];
            if (!word.contains(" ")) {
                lastWordLength = word.length();
                break;
            }
        }
         
       return lastWordLength; 
    }
    
}
