// https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array

class Solution {

    fun countPairs(nums: IntArray, k: Int): Int {
        var pairCount = 0;

        for (i in 0 until nums.size-1) {
            for (j in i+1 until nums.size) {
                if (nums[i] == nums[j] && (i*j % k == 0)) {
                    pairCount++;
                }
            }
        }

        return pairCount;
    }

}
