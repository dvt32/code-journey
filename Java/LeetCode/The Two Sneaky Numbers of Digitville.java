// https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/

class Solution {

    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        List<Integer> sneakyNums = new ArrayList<>();
        
        for (int num : nums) {
            if (uniqueNums.contains(num)) {
                sneakyNums.add(num);
            } else {
                uniqueNums.add(num);
            }
        }

        return new int[] { sneakyNums.get(0), sneakyNums.get(1) };
    }

}
