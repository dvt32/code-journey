// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        TreeSet<Integer> uniqueSortedNums = new TreeSet<>();
        for (int num : nums) {
            uniqueSortedNums.add(num);
        }

        int maxLength = 1;
        int length = 0;
        for (Integer num : uniqueSortedNums) {
            Integer lower = uniqueSortedNums.lower(num);
            if (lower != null && lower != num-1) {
                length = 1;
            } else {
                length++;
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }
    
}
