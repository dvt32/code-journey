// https://leetcode.com/problems/number-of-employees-who-met-the-target

class Solution {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;

        for (int h : hours) {
            if (h >= target) {
                count++;
            }
        }

        return count;
    }

    // Alternative solution
    /*
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours)
            .filter((el) -> el >= target)
            .count();
    }
    */
    
}
