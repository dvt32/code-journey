// https://leetcode.com/problems/binary-number-with-alternating-bits/

class Solution {
    
    public boolean hasAlternatingBits(int n) {
        String num = Integer.toBinaryString(n);
        
        for (int i = 1; i < num.length(); ++i) {
            if (num.charAt(i) == num.charAt(i-1)) {
                return false;
            }
        }
        
        return true;
    }
}
