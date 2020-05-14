// https://leetcode.com/problems/plus-one

import java.math.BigInteger; 

class Solution {

    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        
        String numberStr = sb.toString();
        BigInteger newNumber = new BigInteger(numberStr);
        newNumber = newNumber.add(BigInteger.ONE);
        String newNumberStr = String.valueOf(newNumber);
        
        int[] newNumberDigits = new int[newNumberStr.length()];
        for (int i = 0; i < newNumberDigits.length; ++i) {
            newNumberDigits[i] = Character.getNumericValue( newNumberStr.charAt(i) );
        }
       
        return newNumberDigits;
    }
    
}
