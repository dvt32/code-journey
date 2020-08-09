// https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            boolean isPeak = true;
            
            for (int j = 0; j < i; ++j) {
                if (A[j] > A[j+1]) {
                    isPeak = false;
                    break;
                }
            }
            
            if (!isPeak) {
                continue;
            }
            
            for (int j = i; j < A.length; ++j) {
                if (j+1 < A.length && A[j] < A[j+1]) {
                    isPeak = false;
                    break;
                }
            }
                
            if (isPeak) {
                return i;
            }
        }
        
        return -1;
    }
    
}
