// https://leetcode.com/problems/k-diff-pairs-in-an-array/

class Solution {
  
    fun findPairs(nums: IntArray, k: Int): Int {
        val uniquePairs = mutableSetOf<String>();

        for (i in 0 until nums.size) {
            for (j in i+1 until nums.size) {
                if (abs(nums[i]-nums[j]) == k) {
                    val a = Math.min(nums[i], nums[j]);
                    val b = Math.max(nums[i], nums[j]);
                    uniquePairs.add("$a,$b");
                }
            }
        }

        return uniquePairs.size;
    }
    
}
