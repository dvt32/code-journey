// https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array

class Solution {

    fun differenceOfSum(nums: IntArray): Int {
        var elementSum = 0
        var digitSum = 0

        nums.forEach {
            elementSum += it;
            val numStr = it.toString()
            for (c in numStr) {
                digitSum += Character.getNumericValue(c);
            }
        }

        return Math.abs(elementSum - digitSum);
    }

}
