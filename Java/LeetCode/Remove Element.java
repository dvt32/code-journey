// https://leetcode.com/problems/remove-element

class Solution {
    
    public int removeElement(int[] nums, int val) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        
        numsList.removeAll( Collections.singleton(val) );
        
        for (int i = 0; i < numsList.size(); ++i) {
            nums[i] = numsList.get(i);
        }
        
        return numsList.size();
    
    }
}
