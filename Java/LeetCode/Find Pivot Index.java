// https://leetcode.com/problems/find-pivot-index

class Solution {

    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int leftSum = 0, rightSum = 0;

            for (int j = 0; j < i; ++j) {
                leftSum += nums[j];
            }
            for (int j = nums.length-1; j > i; --j) {
                rightSum += nums[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

}
