// https://leetcode.com/problems/power-of-three/

class Solution {

    public boolean isPowerOfThree(int n) {
        if (n > 0) {
            while (n % 3 == 0) {
                n /= 3;
            }
        }
        return n == 1;
    }
    
}
