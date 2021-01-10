// https://leetcode.com/problems/sort-array-by-increasing-frequency/

class Solution {
    
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> numFrequencies = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        
        for (int num : nums) {
            int frequencyCount = numFrequencies.getOrDefault(num, 0);
            numFrequencies.put(num, frequencyCount+1);
            numbers.add(num);
        }
        
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int aFrequencyCount = numFrequencies.get(a);
                int bFrequencyCount = numFrequencies.get(b);
                if (aFrequencyCount == bFrequencyCount) {
                    return Integer.compare(b, a); // descending order
                }
                else {
                    return Integer.compare(aFrequencyCount, bFrequencyCount);
                }
            }
        });
        
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

}
