// https://leetcode.com/problems/reverse-words-in-a-string/

import java.util.StringJoiner;

class Solution {

    fun reverseWords(s: String): String {
        val words = s.trim().split(" +".toRegex());
        val output = StringJoiner(" ");

        for (i in words.size-1 downTo 0) {
            output.add(words[i]);
        }

        return output.toString();
    }

    // Alternative solution
    /*
    fun reverseWords(s: String): String {
        return s.trim().split(" +".toRegex()).asReversed().joinToString(" ");
    }
    */
    
}
