// https://leetcode.com/problems/largest-number-at-least-twice-of-others/

class Solution {

    fun dominantIndex(nums: IntArray): Int {
        val max = nums.max()
        var maxIndex = -1

        for (i in 0 until nums.size) {
            if (nums[i] == max) {
                maxIndex = i
            } else if (nums[i]*2 > max) {
                return -1
            } 
        }

        return maxIndex
    }

}
