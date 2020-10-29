// https://leetcode.com/problems/monotonic-array/

class Solution {

    public boolean isMonotonic(int[] A) {
        boolean isMonotoneIncreasing = true;
        boolean isMonotoneDecreasing = true;
        
        for (int i = 0; i < A.length-1; ++i) {
            if (A[i] > A[i+1]) {
                isMonotoneIncreasing = false;
            }
            if (A[i] < A[i+1]) {
                isMonotoneDecreasing = false;
            }
        }      
        
        return isMonotoneIncreasing || isMonotoneDecreasing;
    }
    
}
