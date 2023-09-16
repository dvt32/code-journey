// https://leetcode.com/problems/count-prefixes-of-a-given-string

class Solution {
  
    fun countPrefixes(words: Array<String>, s: String): Int {
        var count = 0;
        
        for (word in words) {
            if (s.startsWith(word)) {
                count++
            }
        }

        return count;
    }
    
}
