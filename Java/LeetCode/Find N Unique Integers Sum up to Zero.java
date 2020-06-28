// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero

class Solution {

    public int[] sumZero(int n) {
        int[] arr = new int[n];
        
        int i = 0;
        if (n % 2 == 1) {
            i = 1;
            arr[0] = 0;
        }
        
        while (i < n) {
            arr[i] = i+1;
            arr[i+1] = -(i+1);
            i += 2;
        }
        
        return arr;
    }
    
}
