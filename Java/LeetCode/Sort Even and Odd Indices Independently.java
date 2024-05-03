// https://leetcode.com/problems/sort-even-and-odd-indices-independently/

class Solution {

    public int[] sortEvenOdd(int[] nums) {
        List<Integer> oddIndexNumbers = new ArrayList<>();
        List<Integer> evenIndexNumbers = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                evenIndexNumbers.add(nums[i]);
            } else {
                oddIndexNumbers.add(nums[i]);
            }
        }

        Collections.sort(evenIndexNumbers);
        Collections.sort(oddIndexNumbers, Collections.reverseOrder());

        int[] sortedArr = new int[nums.length];
        for (int i = 0, j = 0, k = 0; i < nums.length; ++i) {
            sortedArr[i] = (i % 2 == 0) ? evenIndexNumbers.get(j++) : oddIndexNumbers.get(k++);
        }

        return sortedArr;
    }

}
