// https://leetcode.com/problems/find-the-distinct-difference-array

class Solution {

    fun distinctDifferenceArray(nums: IntArray): IntArray {
        var diff = IntArray(nums.size)

        for (i in 0..nums.size-1) {
            var prefixNums = mutableSetOf<Int>()
            var suffixNums = mutableSetOf<Int>()

            for (j in 0..i) {
                prefixNums.add(nums[j])
            }
            for (j in i+1..nums.size-1) {
                suffixNums.add(nums[j])
            }

            diff[i] = prefixNums.size - suffixNums.size
        }

        return diff
    }

}
