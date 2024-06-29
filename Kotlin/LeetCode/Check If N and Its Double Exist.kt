// https://leetcode.com/problems/check-if-n-and-its-double-exist/

class Solution {

    fun checkIfExist(arr: IntArray): Boolean {
        for (i in 0 until arr.size) {
            for (j in 0 until arr.size) {
                if (arr[i] == 2*arr[j] && i != j) {
                    return true
                }
            }
        }

        return false
    }

}
