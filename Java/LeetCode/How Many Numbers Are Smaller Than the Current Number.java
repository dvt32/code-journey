// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] mins = new int[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            mins[i] = 0;
            for (int j = 0; j < nums.length; ++j) {
                if (nums[j] < nums[i]) {
                    mins[i]++;
                }
            }
        }
        
        return mins;
    }
    
}
