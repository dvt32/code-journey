// https://leetcode.com/problems/rearrange-array-elements-by-sign/

class Solution {

    public int[] rearrangeArray(int[] nums) {
        List<Integer> negativeNums = new ArrayList<>();
        List<Integer> positiveNums = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                positiveNums.add(nums[i]);
            } else {
                negativeNums.add(nums[i]);
            }
        }

        for (int i = 0, j = 0, k = 0; i < nums.length-1; i += 2) {
            nums[i] = positiveNums.get(j++);
            nums[i+1] = negativeNums.get(k++);
        }

        return nums;
    }

}
