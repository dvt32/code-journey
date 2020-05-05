// https://leetcode.com/problems/reverse-integer/

class Solution {

    public int reverse(int x) {
        String reversed = new StringBuilder(String.valueOf(x)).reverse().toString();
        if (x < 0) {
            reversed = "-" + reversed.substring(0, reversed.length()-1);
        }
        
        long result = Long.parseLong(reversed);
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        else {
            return (int) result;
        }
    }
    
}
