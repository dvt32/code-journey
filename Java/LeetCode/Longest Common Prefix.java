// https://leetcode.com/problems/longest-common-prefix/

class Solution {
    
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        
        String shortestStr = "";
        int shortestStrLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < shortestStrLength) {
                shortestStr = str;
                shortestStrLength = str.length();
            }
        }
        
        String longestCommonPrefix = "";
        for (int i = 0; i < shortestStrLength; ++i) {
            String prefix = shortestStr.substring(0, shortestStrLength-i);
            
            boolean isCommonPrefix = true;
            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    isCommonPrefix = false;
                    break;
                }
            }
            
            if (isCommonPrefix) {
                longestCommonPrefix = prefix;
                break;
            }
        }
        
        return longestCommonPrefix;
    }
    
}
