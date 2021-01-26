// https://leetcode.com/problems/single-number-ii/

class Solution {
    
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numFrequencies = new HashMap<>();

        for (int num : nums) {
            numFrequencies.put( num, numFrequencies.getOrDefault(num, 0) + 1 );
        }

        return numFrequencies.entrySet().stream()
            .sorted( Map.Entry.comparingByValue() )
            .findFirst().get().getKey();
    }
    
}
