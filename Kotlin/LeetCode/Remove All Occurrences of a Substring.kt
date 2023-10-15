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

// Recursive solution
/*
class Solution {
    fun removeOccurrences(s: String, part: String): String {
        if (!s.contains(part)) {
            return s
        } 
        return removeOccurrences(s.replaceFirst(part, ""), part);
    }
}
*/
