// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

class Solution {

    public int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int firstMaxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > firstMax) {
                firstMax = nums[i];
                firstMaxIndex = i;
            }
        }
        
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > secondMax && i != firstMaxIndex) {
                secondMax = nums[i];
            }
        }
        
        return (firstMax-1) * (secondMax-1);
    }
    
}
