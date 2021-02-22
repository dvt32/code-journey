// https://leetcode.com/problems/merge-strings-alternately/

class Solution {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        
        int loopEndIndex = Math.min(word1.length(), word2.length()) - 1;
        for (int i = 0; i <= loopEndIndex; ++i) {
            merged.append( word1.charAt(i) );
            merged.append( word2.charAt(i) );
        }
        
        if (word1.length() < word2.length()) {
            merged.append( word2.substring(word1.length()) );
        }
        else if (word1.length() > word2.length()) {
            merged.append( word1.substring(word2.length()) );
        }
        
        return merged.toString();
    }
    
}
