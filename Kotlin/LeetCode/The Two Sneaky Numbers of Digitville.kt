// https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/

class Solution {

    fun getSneakyNumbers(nums: IntArray): IntArray {
        val uniqueNums = mutableSetOf<Int>();
        val sneakyNums = mutableListOf<Int>();

        nums.forEach {
            if (uniqueNums.contains(it)) {
                sneakyNums.add(it);
            } else {
                uniqueNums.add(it);
            }
        }

        return intArrayOf(sneakyNums[0], sneakyNums[1]);
    }

}
