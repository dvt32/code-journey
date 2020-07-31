// https://leetcode.com/problems/maximum-69-number/

class Solution {

    public int maximum69Number (int num) {
        char[] numDigits = String.valueOf(num).toCharArray();
        
        for (int i = 0; i < numDigits.length; ++i) {
            if (numDigits[i] == '6') {
                numDigits[i] = '9';
                break;
            }
        }
        
        return Integer.parseInt( String.valueOf(numDigits) );
    }
    
}
