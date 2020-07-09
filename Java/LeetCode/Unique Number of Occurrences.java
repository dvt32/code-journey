// https://leetcode.com/problems/unique-number-of-occurrences/

class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numberOccurrences = new HashMap<>();
        
        for (int number : arr) {
            numberOccurrences.put(number, numberOccurrences.getOrDefault(number, 0)+1);
        }
        
        Set<Integer> uniqueNumberOccurrenceValues = new HashSet<>(numberOccurrences.values());
        
        return uniqueNumberOccurrenceValues.size() == numberOccurrences.size();
    }
    
}
