// https://leetcode.com/problems/first-bad-version/


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {
        int L = 1, R = n, result = -1;
        
        while (L <= R) {
            int mid = L + ((R-L)/2); // avoid overflow
            if ( !isBadVersion(mid) ) {
                L = mid+1;
            }
            else {
                R = mid-1;
                result = mid;
            }
        }
        
        return result;
    }
    
}
