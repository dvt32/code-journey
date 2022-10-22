// https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring

class Solution {

    public int longestContinuousSubstring(String s) {
        int maxLength = (s.isEmpty() ? 0 : 1);

        for (int i = 1, length = 1; i < s.length(); ++i) {
            if (s.charAt(i) != (s.charAt(i-1)+1)) {
                length = 1;
            } else {
                length++;
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }
    
}
