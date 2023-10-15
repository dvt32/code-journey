// https://leetcode.com/problems/remove-all-occurrences-of-a-substring

class Solution {
    fun removeOccurrences(s: String, part: String): String {
        var str = s
        
        while (str.contains(part)) {
            str = str.replaceFirst(part, "")
        }

        return str
    }
}
