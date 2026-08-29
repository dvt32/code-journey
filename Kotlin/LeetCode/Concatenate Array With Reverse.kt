// https://leetcode.com/problems/concatenate-array-with-reverse

class Solution {
    fun concatWithReverse(nums: IntArray): IntArray {
        val result = IntArray(nums.size*2);

        for (i in 0 until nums.size) {
            result[i] = nums[i];
            result[nums.size+i] = nums[nums.size-1-i];
        }

        return result;
    }
}
