// https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/

class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        
        Arrays.sort(nums);
        
        List<Integer> minSubsequence = new ArrayList<>();
        int minSubsequenceSum = 0;
        for (int i = nums.length-1; i >= 0; --i) {
            minSubsequence.add(nums[i]);
            minSubsequenceSum += nums[i];
            if (minSubsequenceSum > totalSum-minSubsequenceSum) {
                break;
            }
        }
        
        return minSubsequence;
    }
    
}
