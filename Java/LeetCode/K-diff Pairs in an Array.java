// https://leetcode.com/problems/k-diff-pairs-in-an-array/

class Solution {

    public int findPairs(int[] nums, int k) {
        Set<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                if (Math.abs(nums[i]-nums[j]) == k) {
                    int a = Math.min(nums[i], nums[j]);
                    int b = Math.max(nums[i], nums[j]);
                    uniquePairs.add(a + "," + b);
                }
            }
        }

        return uniquePairs.size();
    }
    
}
