// https://leetcode.com/problems/duplicate-zeros/

class Solution {
    
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length-1; ++i) {
            if (arr[i] == 0) {
                // Shift array to the right (and simultaneously duplicate encountered 0)
                for (int j = arr.length-1; j > i; --j) {
                    arr[j] = arr[j-1];
                }
                // Avoid the 0 that was just duplicated on next iteration
                i++;
            }
        }
    }
     
}
