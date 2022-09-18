// https://leetcode.com/problems/count-asterisks/

class Solution {

    public int countAsterisks(String s) {
        String[] parts = s.split("\\|");
        
        int result = 0;
        for (int i = 0; i < parts.length; i += 2) {
            for (int j = 0; j < parts[i].length(); ++j) {
                if (parts[i].charAt(j) == '*') {
                    result++;
                }
            }
        }
        
        return result;
    }
    
}
