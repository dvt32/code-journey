// https://leetcode.com/problems/find-the-middle-index-in-array

class Solution {

    fun findMiddleIndex(nums: IntArray): Int {
        for (i in 0 until nums.size) {
            var leftSum = 0
            var rightSum = 0

            for (j in 0 until i) {
                leftSum += nums[j]
            }
            for (j in nums.size-1 downTo i+1) {
                rightSum += nums[j]
            }

            if (leftSum == rightSum) {
                return i
            }
        }

        return -1
    }

}
