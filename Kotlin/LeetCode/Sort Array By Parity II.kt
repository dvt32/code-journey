// https://leetcode.com/problems/sort-array-by-parity-ii/

class Solution {

    fun sortArrayByParityII(nums: IntArray): IntArray {
        var oddNumbers = arrayListOf<Int>();
        var evenNumbers = arrayListOf<Int>();

        for (i in 0 until nums.size) {
            if (nums[i] % 2 == 0) {
                evenNumbers.add(nums[i]);
            } else {
                oddNumbers.add(nums[i]);
            }
        }

        var sortedArr = IntArray(nums.size)
        var j = 0
        var k = 0
        for (i in 0 until nums.size) {
            sortedArr[i] = if (i % 2 == 0) evenNumbers.get(j++) else oddNumbers.get(k++)
        }

        return sortedArr;
    }

}
