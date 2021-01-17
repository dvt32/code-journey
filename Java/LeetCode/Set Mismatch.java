// https://leetcode.com/problems/set-mismatch/

class Solution {
    
    public int[] findErrorNums(int[] nums) {
        int totalSum = 0;
        int numSum = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            totalSum += i+1;
            numSum += nums[i];
        }
        
        Set<Integer> uniqueNums = new HashSet<>();
        int duplicateNum = 0;
        for (int num : nums) {
            if (!uniqueNums.add(num)) {
                duplicateNum = num;
                break;
            }
        }
        
        return new int[] { duplicateNum, totalSum - (numSum - duplicateNum) };
    }
    
}
