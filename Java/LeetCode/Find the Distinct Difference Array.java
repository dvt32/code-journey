// https://leetcode.com/problems/find-the-distinct-difference-array

class Solution {

    public int[] distinctDifferenceArray(int[] nums) {
        int[] diff = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            Set<Integer> prefixNums = new HashSet<>();
            Set<Integer> suffixNums = new HashSet<>();
            
            for (int j = 0; j <= i; ++j) {
                prefixNums.add(nums[j]);
            }
            for (int j = i+1; j < nums.length; ++j) {
                suffixNums.add(nums[j]);
            }

            diff[i] = prefixNums.size() - suffixNums.size();
        }

        return diff;
    }

}
