// https://leetcode.com/problems/running-sum-of-1d-array

class Solution {
    
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            runningSum[i] = 0;
            for (int j = 0; j <= i; ++j) {
                runningSum[i] += nums[j];
            }
        }
        
        return runningSum;
    }
    
}
