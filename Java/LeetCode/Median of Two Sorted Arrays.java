// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        
        for (int i = 0; i < nums1.length; ++i) {
            nums[i] = nums1[i];
        }
        for (int j = nums1.length, i = 0; j < nums.length; ++j, ++i) {
            nums[j] = nums2[i];
        }
        
        Arrays.sort(nums);
        
        if (nums.length % 2 == 1) {
            return (double) nums[nums.length/2];
        }
        
        return (double) (nums[nums.length/2] + nums[nums.length/2-1]) / 2.0;
    }
}
