// https://leetcode.com/problems/reverse-words-in-a-string-iii/

import java.util.StringJoiner;

class Solution {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        
        StringJoiner joiner = new StringJoiner(" ");
        for (String word : words) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            joiner.add(reversedWord);
        }
        
        return joiner.toString();
    }
    
}
