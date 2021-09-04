// https://leetcode.com/problems/valid-anagram/

class Solution {
    
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
    
    // Alternative solution
    /*
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> sCharFrequencies = new HashMap<>();
        Map<Character, Integer> tCharFrequencies = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sCharFrequencies.put( sChar, sCharFrequencies.getOrDefault(sChar, 0) + 1 );
            tCharFrequencies.put( tChar, tCharFrequencies.getOrDefault(tChar, 0) + 1 );
        }
        
        return sCharFrequencies.equals(tCharFrequencies);
    }
    */
    
}
