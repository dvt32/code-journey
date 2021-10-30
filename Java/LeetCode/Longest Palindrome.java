// https://leetcode.com/problems/longest-palindrome/

class Solution {

    public int longestPalindrome(String s) {
        Map<Character, Integer> charFrequencies = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequencies.put( c, charFrequencies.getOrDefault(c, 0)+1 );
        }
        
        int result = 0;
        for (Integer value : charFrequencies.values()) {
            result += (value % 2 == 0) ? value : value-1;
        }
        
        return (result < s.length()) ? result+1 : result;
    }
    
}
