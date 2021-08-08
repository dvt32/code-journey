// https://leetcode.com/problems/next-greater-element-ii/

class Solution {
    
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            int answer = -1; 
            
            boolean foundAnswer = false;
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[j] > nums[i]) {
                    answer = nums[j];
                    foundAnswer = true;
                    break;
                }
            }
            if (!foundAnswer) {
                for (int j = 0; j < i; ++j) {
                    if (nums[j] > nums[i]) {
                        answer = nums[j];
                        break;
                    }
                }
            }
            
            ans[i] = answer;
        }
        
        return ans;
    }
    
}
