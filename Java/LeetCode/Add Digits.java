// https://leetcode.com/problems/add-digits/

class Solution {

    public int addDigits(int num) {
        while (num > 9) {
            int n_copy = num;
            num = 0;
            while (n_copy != 0) {
                num += n_copy % 10;
                n_copy /= 10;
            }
        }
        
        return num;
    }
    
}
