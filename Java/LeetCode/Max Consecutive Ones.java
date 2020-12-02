// https://leetcode.com/problems/max-consecutive-ones/

class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxNumberOfConsecutiveOnes = 0;
        
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                int currentNumberOfConsecutiveOnes = 0;
                while (i < nums.length && nums[i] == 1) {
                    currentNumberOfConsecutiveOnes++;
                    i++;
                }
                maxNumberOfConsecutiveOnes = Math.max(maxNumberOfConsecutiveOnes, currentNumberOfConsecutiveOnes);
            }
            else {
                i++;
            }
        }
        
        return maxNumberOfConsecutiveOnes;
    }

    /*
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxNumberOfConsecutiveOnes = 0;
        int currentNumberOfConsecutiveOnes = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                currentNumberOfConsecutiveOnes++;
                maxNumberOfConsecutiveOnes = Math.max(
                    maxNumberOfConsecutiveOnes, 
                    currentNumberOfConsecutiveOnes
                );
            }
            else {
                currentNumberOfConsecutiveOnes = 0;
            }
        }
        
        return maxNumberOfConsecutiveOnes;
    }
    */
    
}
