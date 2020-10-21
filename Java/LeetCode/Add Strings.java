// https://leetcode.com/problems/add-strings/

class Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder sumOfNumbers = new StringBuilder();

        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
          int digitFromFirstNumber = (i < 0) ? 0 : Integer.parseInt( String.valueOf(num1.charAt(i)) );
          int digitFromSecondNumber = (j < 0) ? 0 : Integer.parseInt( String.valueOf(num2.charAt(j)) );
          int digitOfSum = digitFromFirstNumber + digitFromSecondNumber + carry;

          if (digitOfSum > 9) {
            carry = 1;
            digitOfSum -= 10;
          }
          else {
            carry = 0;
          }

          sumOfNumbers.append(digitOfSum);

          i--;
          j--;
        }

        return sumOfNumbers.reverse().toString();
    }
    
}
