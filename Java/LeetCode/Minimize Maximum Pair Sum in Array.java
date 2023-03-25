// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array

class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int minPairSum = 0;
        for (int i = 0, j = nums.length-1; i < j; ++i, --j) {
            minPairSum = Math.max(minPairSum, nums[i]+nums[j]);
        }

        return minPairSum;
    }

}
