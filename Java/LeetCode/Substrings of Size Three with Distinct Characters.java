// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters

class Solution {
  
    public int countGoodSubstrings(String s) {
        int goodCount = 0;

        for (int i = 0; i < s.length()-2; ++i) {
            String substr = s.substring(i, i+3);
            Set<Character> uniqueChars = new HashSet<>();
            for (int j = 0; j < substr.length(); ++j) {
                uniqueChars.add(substr.charAt(j));
            }
            if (substr.length() == uniqueChars.size()) {
                goodCount++;
            }
        }

        return goodCount;
    }
  
}
