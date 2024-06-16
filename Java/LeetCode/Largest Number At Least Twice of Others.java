// https://leetcode.com/problems/largest-number-at-least-twice-of-others/

class Solution {

    public int dominantIndex(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int maxIndex = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == max) {
                maxIndex = i;
            } else if (nums[i]*2 > max) {
                return -1;
            } 
        }

        return maxIndex;
    }

}
