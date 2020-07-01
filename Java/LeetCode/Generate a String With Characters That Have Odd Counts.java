// https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts

class Solution {
    
    public String generateTheString(int n) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; ++i) {
            result.append("a");
        }
        
        if (n % 2 == 0) {
            result.setCharAt(0, 'b');
        }
        
        return result.toString();
    }
    
}
