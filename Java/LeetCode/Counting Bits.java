// https://leetcode.com/problems/counting-bits/

class Solution {

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        
        for (int i = 1; i <= num; ++i) {
            String binary = Integer.toBinaryString(i);
            for (int j = 0; j < binary.length(); ++j) {
                if (binary.charAt(j) == '1') {
                    result[i]++;
                }
            }
        }
        
        return result;
    }
    
}
