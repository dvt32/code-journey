// https://leetcode.com/problems/find-the-middle-index-in-array

class Solution {

    public int findMiddleIndex(int[] nums) {
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
