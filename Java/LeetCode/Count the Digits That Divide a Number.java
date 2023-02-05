// https://leetcode.com/problems/count-the-digits-that-divide-a-number

class Solution {

    public int countDigits(int num) {
        int count = 0;
        int n = num;

        while (n > 0) {
            int digit = n % 10;
            if (num % digit == 0) {
                count++;
            }
            n /= 10;
        }

        return count;
    }
    
}
