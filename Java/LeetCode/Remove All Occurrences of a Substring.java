// https://leetcode.com/problems/remove-all-occurrences-of-a-substring

class Solution {
  
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }

        return s;
    }
  
}

// Recursive solution
/*
class Solution {
    public String removeOccurrences(String s, String part) {
        if (!s.contains(part)) {
            return s;
        }
        return removeOccurrences(s.replaceFirst(part, ""), part);
    }
}
*/
