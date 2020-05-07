// https://leetcode.com/problems/palindrome-number/

class Solution {

    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        String reversedNumber = new StringBuilder(number).reverse().toString();
        return number.equals(reversedNumber);
    }
    
}
