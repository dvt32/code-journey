// https://leetcode.com/problems/next-greater-element-i/

class Solution {
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; ++i) {
            int answer = -1;
            
            for (int j = 0; j < nums2.length; ++j) {
               if (nums1[i] == nums2[j]) {
                    j++;
                   
                    for (; j < nums2.length; ++j) {
                        if (nums2[j] > nums1[i]) {
                            answer = nums2[j];
                            break;
                        }
                    }
                   
                    break;
                }
            }

            ans[i] = answer;
        }
        
        return ans;
    }
    
}
