// https://leetcode.com/problems/top-k-frequent-elements/

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFrequencies = new HashMap<>();
        
        for (int num : nums) {
            int frequencyCount = numFrequencies.getOrDefault(num, 0);
            numFrequencies.put(num, frequencyCount+1);
        }
        
        int[] result = numFrequencies.entrySet().stream()
            .sorted( Collections.reverseOrder( Map.Entry.comparingByValue() ) )
            .limit(k)
            .mapToInt(entry -> entry.getKey())
            .toArray();
        
        return result;
    }
    
}
