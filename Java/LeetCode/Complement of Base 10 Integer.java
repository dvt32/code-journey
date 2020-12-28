// https://leetcode.com/problems/complement-of-base-10-integer/

class Solution {
    
    public int bitwiseComplement(int N) {
        char[] binary = Integer.toBinaryString(N).toCharArray();
        
        for (int i = 0; i < binary.length; ++i) {
            binary[i] = (binary[i] == '0') ? '1' : '0';
        }
        
        return Integer.parseInt(String.valueOf(binary), 2);
    }
    
}
