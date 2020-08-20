// https://leetcode.com/problems/missing-number/

class Solution {
    
    public int missingNumber(int[] nums) {
        int arrSum = 0;
        int maxSum = nums.length;;
        
        for (int i = 0; i < nums.length; ++i) {
            arrSum += nums[i];
            maxSum += i;
        }
        
        return maxSum - arrSum;
    }
    
}
