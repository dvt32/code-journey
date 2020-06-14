// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer

class Solution {

    public int subtractProductAndSum(int n) {
        String number = String.valueOf(n);
        int product = 1;
        int sum = 0;
        
        for (int i = 0; i < number.length(); ++i) {
            int digit = Character.getNumericValue( number.charAt(i) );
            product *= digit;
            sum += digit;
        }

        return product - sum;
    }
    
}
