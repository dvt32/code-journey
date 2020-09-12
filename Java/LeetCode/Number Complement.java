// https://leetcode.com/problems/number-complement/

class Solution {

    public int findComplement(int num) {
        char[] binary = Integer.toBinaryString(num).toCharArray();
        
        for (int i = 0; i < binary.length; ++i) {
            binary[i] = (binary[i] == '0') ? '1' : '0';
        }
        
        return Integer.parseInt(String.valueOf(binary), 2);
    }
    
}
