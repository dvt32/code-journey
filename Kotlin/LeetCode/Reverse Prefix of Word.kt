// https://leetcode.com/problems/reverse-prefix-of-word/

class Solution {

    fun reversePrefix(word: String, ch: Char): String {
        var chIndex = word.indexOf(ch);
        if (chIndex == -1) {
            return word;
        }

        return word.substring(0, chIndex+1).reversed() + word.substring(chIndex+1);
    }

}
