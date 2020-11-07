// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/

class Solution {
    
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
    
}
