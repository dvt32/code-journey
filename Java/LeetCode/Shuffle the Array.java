// https://leetcode.com/problems/shuffle-the-array/

class Solution {

    public int[] shuffle(int[] nums, int n) {
        int[] shuffledNums = new int[2*n];
        
        for (int i = 0, j = n, k = 0; 
             i < n && j < 2*n;
             ++i, ++j, k += 2) 
        {
            shuffledNums[k] = nums[i];
            shuffledNums[k+1] = nums[j];
        }
        
        return shuffledNums;
    }
    
}
