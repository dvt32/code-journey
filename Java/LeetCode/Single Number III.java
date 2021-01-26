// https://leetcode.com/problems/single-number-iii/

class Solution {

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> numFrequencies = new HashMap<>();
        
        for (int num : nums) {
            numFrequencies.put( num, numFrequencies.getOrDefault(num, 0) + 1 );
        }
        
        return numFrequencies.entrySet().stream()
            .sorted( Map.Entry.comparingByValue() )
            .limit(2)
            .mapToInt( entry -> entry.getKey() )
            .toArray();
    }
    
}
