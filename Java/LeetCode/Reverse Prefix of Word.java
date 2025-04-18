// https://leetcode.com/problems/reverse-prefix-of-word/

class Solution {
  
    public String reversePrefix(String word, char ch) {
        var chIndex = word.indexOf(ch);
        if (chIndex == -1) {
            return word;
        }

        return new StringBuilder(word.substring(0, chIndex+1)).reverse().toString() + word.substring(chIndex+1);
    }
  
}
