// https://leetcode.com/problems/number-of-1-bits/

public class Solution {
    
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        
        int result = 0;
        for (int i = 0; i < binary.length(); ++i) {
            if (binary.charAt(i) == '1') {
                result++;
            }
        }
        
        return result;
    }
    
}
