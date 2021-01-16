// https://leetcode.com/problems/find-the-duplicate-number/

class Solution {

    public int findDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        
        for (int num : nums) {
            if (!uniqueNums.add(num)) {
                return num;
            }
        }
        
        return 0;
    }
    
}
