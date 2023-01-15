// https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/

class Solution {

    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;

        for (int num : nums) {
            elementSum += num;
            String numStr = String.valueOf(num);
            for (int i = 0; i < numStr.length(); ++i) {
                int digit = Character.getNumericValue(numStr.charAt(i));
                digitSum += digit;
            }
        }

        return Math.abs(elementSum - digitSum);
    }
    
}
