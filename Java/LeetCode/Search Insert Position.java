// https://leetcode.com/problems/search-insert-position

class Solution {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0]) {
            return 0;
        }
        else if (target > nums[nums.length-1]) {
            return nums.length;
        }
        
        int L = 0;
        int R = nums.length - 1;
        int targetIndex = -1;

        while (L <= R) {
            int middleElementIndex = (L + R) / 2;

            if (target < nums[middleElementIndex]) {
                R = middleElementIndex - 1;
                
            }
            else if (target > nums[middleElementIndex]) {
                L = middleElementIndex + 1;
            }
            else {
                targetIndex = middleElementIndex;
                return targetIndex;
            }
        }
        
        targetIndex = L;
        
        return targetIndex;
    }
    
}
