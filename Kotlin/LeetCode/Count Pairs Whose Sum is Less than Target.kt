// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/

class Solution {

    fun countPairs(nums: List<Int>, target: Int): Int {
        var pairCount = 0;

        for (i in 0 until nums.size) {
            for (j in i+1 until nums.size) {
                if (nums[i] + nums[j] < target) {
                    pairCount++;
                }
            }
        }

        return pairCount;
    }

}
