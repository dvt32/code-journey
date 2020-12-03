// https://leetcode.com/problems/consecutive-characters/

class Solution {
    
    public int maxPower(String s) {
        int powerOfString = 0;
        
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int numberOfConsecutiveChars = 0;
            while (i < s.length() && s.charAt(i) == c) {
                numberOfConsecutiveChars++;
                i++;
            }
            powerOfString = Math.max(powerOfString, numberOfConsecutiveChars);
        }
        
        return powerOfString;
    }
    
}
