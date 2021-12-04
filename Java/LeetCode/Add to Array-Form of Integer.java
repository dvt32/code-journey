// https://leetcode.com/problems/add-to-array-form-of-integer/

import java.math.BigInteger;

class Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder number = new StringBuilder();
        for (int digit : num) {
            number.append(digit);
        }
        
        String newNum = new BigInteger( number.toString() ).add( new BigInteger(String.valueOf(k)) ).toString();
        List<Integer> newNumDigits = new ArrayList<>();
        for (int i = 0; i < newNum.length(); ++i) {
            newNumDigits.add( Character.getNumericValue(newNum.charAt(i)) );
        }
        
        return newNumDigits;
    }
    
}
