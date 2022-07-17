// https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/

class Solution {
  
    public int minimumSum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return Integer.parseInt("" + digits[0] + digits[2]) + Integer.parseInt("" + digits[1] + digits[3]);
    }
  
}
