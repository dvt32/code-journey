// https://leetcode.com/problems/sort-array-by-parity-ii/

class Solution {

    public int[] sortArrayByParityII(int[] nums) {
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) {
                evenNumbers.add(nums[i]);
            } else {
                oddNumbers.add(nums[i]);
            }
        }

        int[] sortedArr = new int[nums.length];
        for (int i = 0, j = 0, k = 0; i < nums.length; ++i) {
            sortedArr[i] = (i % 2 == 0) ? evenNumbers.get(j++) : oddNumbers.get(k++);
        }

        return sortedArr;
    }

}
