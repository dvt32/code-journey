// https://leetcode.com/problems/majority-element/

class Solution {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numberFrequencies = new HashMap<>();
        int n = nums.length;
        
        for (int num : nums) {
            int currentNumberFrequencies = numberFrequencies.getOrDefault(num, 0);
            numberFrequencies.put(num, currentNumberFrequencies + 1);
            if (numberFrequencies.get(num) > (n/2)) {
                return num;
            }
        }
        
        return 0;
    }
    
}
