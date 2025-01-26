// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/

class Solution {

    fun countKDifference(nums: IntArray, k: Int): Int {
        var pairCount = 0;

        for (i in 0 until nums.size) {
            for (j in i+1 until nums.size) {
                if (abs(nums[i]-nums[j]) == k) {
                    pairCount++;
                }
            }
        }

        return pairCount;
    }

}
