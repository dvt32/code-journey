// https://leetcode.com/problems/smallest-even-multiple

class Solution {

    public int smallestEvenMultiple(int n) {
        int result = n;

        while (result % 2 != 0) {
            result *= 2;
        }

        return result;
    }
    
}
