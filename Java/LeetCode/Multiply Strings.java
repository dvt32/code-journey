// https://leetcode.com/problems/multiply-strings/

import java.math.BigInteger;

class Solution {
    public String multiply(String num1, String num2) {
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }
}
