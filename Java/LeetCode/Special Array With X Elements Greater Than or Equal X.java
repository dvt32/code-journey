// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

class Solution {
    
    public int specialArray(int[] nums) {
        int x = 0;
        
        while (x <= nums.length) {
            int numberOfValuesGreaterOrEqualToX = 0;
            
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] >= x) {
                    numberOfValuesGreaterOrEqualToX++;
                }
            }
            
            if (numberOfValuesGreaterOrEqualToX == x) {
                break;
            }
            
            x++;
        }
        
        return (x > nums.length) ? -1 : x;
    }
    
}
