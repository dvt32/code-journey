// https://leetcode.com/problems/two-sum/

class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int firstIndex = 0;
        int secondIndex = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            boolean foundIndices = false;
            
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    firstIndex = i;
                    secondIndex = j;
                    foundIndices = true;
                    break;
                }
            }
            
            if (foundIndices) {
                break;
            }
        }
        
        return new int[] { firstIndex, secondIndex };
    }
    
}