// https://leetcode.com/problems/left-and-right-sum-differences

class Solution {
    fun leftRightDifference(nums: IntArray): IntArray {
        var answer = IntArray(nums.size);

        for (i in 0 until nums.size) {
            var leftSum = 0;
            var rightSum = 0;

            for (j in 0 until i) {
                leftSum += nums[j];
            }
            for (j in nums.size-1 downTo i+1) {
                rightSum += nums[j];
            }

            answer[i] = Math.abs(leftSum - rightSum);
        }

        return answer;
    }
}
