// https://leetcode.com/problems/find-all-duplicates-in-an-array/

class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicateNums = new ArrayList<>();
        Set<Integer> uniqueNums= new HashSet<>();
        
        for (int num : nums) {
            boolean numExistsInSet = uniqueNums.contains(num);
            if (numExistsInSet) {
                duplicateNums.add(num);
            }
            else {
                uniqueNums.add(num);
            }
        }
            
        return duplicateNums;
    }
    
    // Alternative solution
    /*
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> numFrequencies = new HashMap<>();
        
        List<Integer> duplicates = new ArrayList<>();
        for (int num : nums) {
            int updatedNumFrequencyCount = numFrequencies.getOrDefault(num, 0) + 1;
            numFrequencies.put(num, updatedNumFrequencyCount);
            if (updatedNumFrequencyCount == 2) {
                duplicates.add(num);
            }
        }
        
        return duplicates;
    }
    */
    
}
