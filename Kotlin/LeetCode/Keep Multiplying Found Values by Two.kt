// https://leetcode.com/problems/keep-multiplying-found-values-by-two/

class Solution {

    fun findFinalValue(nums: IntArray, original: Int): Int {
        var current = original
        while (nums.contains(current)) {
             current *= 2
        }
        return current
    }

    // Alternative solution
    /*
    fun findFinalValue(nums: IntArray, original: Int): Int {
        var finalValue = original
        var foundOriginal = true
        var originalNum = original

        while (foundOriginal) {
            foundOriginal = false
            for (i in 0 until nums.size) {
                if (nums[i] == originalNum) {
                    foundOriginal = true
                    originalNum *= 2
                    finalValue = originalNum
                    break
                }
            }
        }
        
        return finalValue
    }
    */
    
}
