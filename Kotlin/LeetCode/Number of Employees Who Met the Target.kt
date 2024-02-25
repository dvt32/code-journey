// https://leetcode.com/problems/number-of-employees-who-met-the-target

class Solution {

    fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
        var count = 0;

        for (h in hours) {
            if (h >= target) {
                count++;
            }
        }

        return count;
    }

    // Alternative solution
    /*
    fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int) = hours.count { it >= target }
    */

}
