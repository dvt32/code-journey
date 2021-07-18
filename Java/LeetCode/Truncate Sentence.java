// https://leetcode.com/problems/truncate-sentence/

import java.util.StringJoiner;

class Solution {
    
    public String truncateSentence(String s, int k) {
        StringJoiner output = new StringJoiner(" ");
        
        String[] words = s.split(" ");
        for (int i = 0; i < k; ++i) {
            output.add(words[i]);
        }
        
        return output.toString();
    }
    
}
