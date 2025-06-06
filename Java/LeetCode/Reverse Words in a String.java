// https://leetcode.com/problems/reverse-words-in-a-string/

import java.util.StringJoiner;

class Solution {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        StringJoiner output = new StringJoiner(" ");

        for (int i = words.length-1; i >= 0; --i) {
            output.add(words[i]);
        }

        return output.toString();
    }

    // Alternative solution
    /*
    public String reverseWords(String s) {
        String[] words = s.split(" +");
        
        StringJoiner output = new StringJoiner(" ");

        for (int i = words.length-1; i >= 0; --i) {
            if (!words[i].isBlank()) {
                output.add(words[i]);
            }
        }

        return output.toString();
    }
    */
    
}
