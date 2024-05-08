// https://leetcode.com/problems/sort-array-by-parity/

class Solution {

    fun sortArrayByParity(nums: IntArray): IntArray {
        return nums.sortedWith(compareBy<Int> { it % 2 != 0 }.then(compareBy { it })).toIntArray()
    }

}
