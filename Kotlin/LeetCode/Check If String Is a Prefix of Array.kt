// https://leetcode.com/problems/check-if-string-is-a-prefix-of-array

class Solution {
  
    fun isPrefixString(s: String, words: Array<String>): Boolean {
        var sb = StringBuilder()

        for (word in words) {
            sb.append(word)
            if (sb.length == s.length) {
                return (sb.toString() == s);
            }
            else if (sb.length > s.length) {
                return false;
            }
        }

        return false;
    }
    
}
