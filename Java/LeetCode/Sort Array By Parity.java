// https://leetcode.com/problems/sort-array-by-parity/

class Solution {

    public int[] sortArrayByParity(int[] nums) {
        return Arrays.stream(nums)
            .boxed()
            .sorted((a, b) -> {
                int parityComparison = Integer.compare(a % 2, b % 2);
                return (parityComparison == 0) ? Integer.compare(a, b) : parityComparison;
            })
            .mapToInt(i -> i)
            .toArray();
    }

}
