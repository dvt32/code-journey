// https://leetcode.com/problems/min-max-game

class Solution {

    fun minMaxGame(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) {
            return nums[0]
        }

        val newNums = IntArray(n/2)
        for (i in 0 until n/2 step 2) {
            newNums[i] = Math.min(nums[2*i], nums[2*i+1]);
        }
        for (i in 1 until n/2 step 2) {
            newNums[i] = Math.max(nums[2*i], nums[2*i+1]);
        }

        return minMaxGame(newNums)
    }

}
