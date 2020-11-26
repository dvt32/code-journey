// https://leetcode.com/problems/delete-columns-to-make-sorted/

class Solution {
    
    public int minDeletionSize(String[] A) {
        int result = 0;
        
        // The problem is essentially asking how many columns are not in non-decreasing order.
        for (int c = 0; c < A[0].length(); ++c) {
            for (int i = 1; i < A.length; ++i) {
                if (A[i-1].charAt(c) > A[i].charAt(c)) {
                    result++;
                    break;
                }
            }
        }
        
        return result;
    }
    
}
