// https://leetcode.com/problems/left-and-right-sum-differences

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            int leftSum = 0, rightSum = 0;

            for (int j = 0; j < i; ++j) {
                leftSum += nums[j];
            }
            for (int j = nums.length-1; j > i; --j) {
                rightSum += nums[j];
            }

            answer[i] = Math.abs(leftSum - rightSum);
        }

        return answer;
    }
}
