// https://leetcode.com/problems/first-missing-positive/

class Solution {
    
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        
        int i = 0;
        
        // Move through negative numbers
        while (i < nums.length && nums[i] <= 0) {
            i++;  
        }
        
        // If there are no positive numbers 
        // or first positive number is not 1, 
        // then smallest missing positive integer is 1.
        if (i == nums.length || nums[i] != 1) {
            return 1;
        }
        
        // Move through positive numbers.
        // If next positive number 
        // is not equal to previous positive number + 1
        // and is not equal to the previous positive number itself,
        // then the smallest missing positive number
        // is the previous positive number + 1.
        while (i < nums.length-1) {
            if (nums[i+1] != nums[i]+1 && nums[i+1] != nums[i]) {
                return nums[i]+1;
            }
            i++;
        }
        
        // If there are no missing positive numbers
        // in the range of the positive numbers in the array,
        // then the smallest missing positive number
        // is the last (largest) positive number in the array + 1
        // (next positive number in natural order).
        return nums[nums.length-1]+1;
    }
    
}
