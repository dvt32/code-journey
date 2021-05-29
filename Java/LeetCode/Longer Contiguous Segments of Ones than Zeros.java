// https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros

class Solution {
    
    public boolean checkZeroOnes(String s) {
        int maxOneSegmentLength = 0;
        int maxZeroSegmentLength = 0;
        
        int i = 0;
        while (i < s.length()) {
            int oneSegmentLength = 0;
            int zeroSegmentLength = 0;
            
            while (i < s.length() && s.charAt(i) == '1') {
                oneSegmentLength++;
                i++;
            }
            maxOneSegmentLength = Math.max(oneSegmentLength, maxOneSegmentLength);
            
            while (i < s.length() && s.charAt(i) == '0') {
                zeroSegmentLength++;
                i++;
            }
            maxZeroSegmentLength = Math.max(zeroSegmentLength, maxZeroSegmentLength);
        }    
        
        return (maxOneSegmentLength > maxZeroSegmentLength);
    }
    
}
