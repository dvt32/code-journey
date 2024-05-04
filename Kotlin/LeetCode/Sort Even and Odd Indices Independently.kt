// https://leetcode.com/problems/sort-even-and-odd-indices-independently/

class Solution {

    fun sortEvenOdd(nums: IntArray): IntArray {
        var oddIndexNumbers = arrayListOf<Int>();
        var evenIndexNumbers = arrayListOf<Int>();

        for (i in 0 until nums.size) {
            if (i % 2 == 0) {
                evenIndexNumbers.add(nums[i]);
            } else {
                oddIndexNumbers.add(nums[i]);
            }
        }

        evenIndexNumbers.sort();
        oddIndexNumbers.sortDescending();

        var sortedArr = IntArray(nums.size)
        var j = 0
        var k = 0
        for (i in 0 until nums.size) {
            sortedArr[i] = if (i % 2 == 0) evenIndexNumbers.get(j++) else oddIndexNumbers.get(k++)
        }

        return sortedArr;
    }

}
