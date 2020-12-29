// https://leetcode.com/problems/contains-duplicate/

class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        
        for (int num : nums) {
            numSet.add(num);
        }
        
        return (numSet.size() < nums.length);
    }
    
}
