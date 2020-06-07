// https://leetcode.com/problems/find-lucky-integer-in-an-array

class Solution {
    
    public int findLucky(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        
        Map<Integer, Integer> numberFrequencies = new HashMap<>();
        for (Integer number : arr) {
            if (numberFrequencies.containsKey(number)) {
                int frequencyCount = numberFrequencies.get(number);
                numberFrequencies.put(number, frequencyCount+1);
            }
            else {
                numberFrequencies.put(number,  1);
            }
        }
        
        int largestLuckyInteger = -1;
        for (Integer number : numberFrequencies.keySet()) {
            if (number == numberFrequencies.get(number)) {
                largestLuckyInteger = Math.max(largestLuckyInteger, number);
            }
        }
        
        return largestLuckyInteger;
    }
    
}
