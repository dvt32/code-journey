// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numFrequencies = new HashMap<>();
        
        for (int num : arr) {
            int numFrequencyCount = numFrequencies.getOrDefault(num, 0);
            numFrequencies.put(num, numFrequencyCount+1);
        }
        
        List< Map.Entry<Integer, Integer> > numFrequenciesList = numFrequencies.entrySet().stream()
            .sorted( Map.Entry.comparingByValue() )
            .collect( Collectors.toList() );
        
        Iterator< Map.Entry<Integer, Integer> > it = numFrequenciesList.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            Integer entryValue = entry.getValue();
            if (entryValue <= k) {
                k -= entryValue;
                it.remove();
            }
            else {
                break;
            }
        }
        
        return numFrequenciesList.size();
    }
    
}
