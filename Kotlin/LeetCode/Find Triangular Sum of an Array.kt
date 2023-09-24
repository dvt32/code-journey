// https://leetcode.com/problems/find-triangular-sum-of-an-array

class Solution {
  
    fun triangularSum(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) {
            return nums[0]
        }

        val newNums = IntArray(n-1)
        for (i in 0 until n-1) {
            newNums[i] = (nums[i] + nums[i+1]) % 10
        }

        return triangularSum(newNums)
    }
    
}
