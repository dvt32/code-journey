// https://leetcode.com/problems/rearrange-array-elements-by-sign/

class Solution {
    
    fun rearrangeArray(nums: IntArray): IntArray {
        val negativeNums = mutableListOf<Int>();
        val positiveNums = mutableListOf<Int>();

        for (i in 0 until nums.size) {
            if (nums[i] > 0) {
                positiveNums.add(nums[i]);
            } else {
                negativeNums.add(nums[i]);
            }
        }

        var j = 0;
        var k = 0;
        for (i in 0 until nums.size-1 step 2) {
            nums[i] = positiveNums.get(j++);
            nums[i+1] = negativeNums.get(k++);
        }

        return nums;
    }

}
