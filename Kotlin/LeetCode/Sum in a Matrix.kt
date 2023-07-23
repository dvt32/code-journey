// https://leetcode.com/problems/sum-in-a-matrix

class Solution {

    fun matrixSum(nums: Array<IntArray>): Int {
        var removed = Array(nums.size) { BooleanArray(nums[0].size) }
        var score = 0
        var stillRemoving = true

        while (stillRemoving) {
            var removedNums = sortedSetOf<Int>()
            stillRemoving = false

            for (i in 0 until nums.size) {
                var max = -1
                var maxIndex = -1

                for (j in 0 until nums[i].size) {
                    if (nums[i][j] > max && !removed[i][j]) {
                        max = nums[i][j]
                        maxIndex = j
                        stillRemoving = true
                    }
                }

                if (stillRemoving) {
                    removed[i][maxIndex] = true
                    removedNums.add(nums[i][maxIndex])
                }  
            }

            if (stillRemoving) {
                score += removedNums.last()
            }
        }

        return score;
    }
    
}
