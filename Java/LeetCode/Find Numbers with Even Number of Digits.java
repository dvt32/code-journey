// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

class Solution {

    public int findNumbers(int[] nums) {
        int result = 0;
        
        for (Integer num : nums) {
            String number = String.valueOf(num);
            if (number.length() % 2 == 0) {
                result++;
            }
        }
        
        return result;
    }
    
}
