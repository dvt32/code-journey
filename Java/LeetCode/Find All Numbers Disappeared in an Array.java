// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class Solution {
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] frequencies = new int[n+1];
        
        for (int num : nums) {
            frequencies[num]++;
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (frequencies[i] == 0) {
                result.add(i);
            }
        }
        
        return result;
    }
    
}
