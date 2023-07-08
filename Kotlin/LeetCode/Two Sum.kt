// https://leetcode.com/problems/two-sum

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var (firstIndex, secondIndex) = arrayOf(0, 0)

        for (i in 0 until nums.size) {
            var foundIndices = false
            for (j in i+1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    firstIndex = i;
                    secondIndex = j
                    foundIndices = true
                    break
                }
            }
            if (foundIndices) {
                break
            }
        }

        return intArrayOf(firstIndex, secondIndex);
    }
}
