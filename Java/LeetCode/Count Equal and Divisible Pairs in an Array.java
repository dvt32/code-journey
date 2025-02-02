// https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/

class Solution {

    public int countPairs(int[] nums, int k) {
        int pairCount = 0;

        for (int i = 0; i < nums.length-1; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[i] == nums[j] && (i*j % k == 0)) {
                    pairCount++;
                }
            }
        }

        return pairCount;
    }

}
