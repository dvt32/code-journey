// https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number

class Solution {

    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[0];
        }

        long n = num / 3;
        return new long[] { n-1, n, n+1 };
    }
    
}
