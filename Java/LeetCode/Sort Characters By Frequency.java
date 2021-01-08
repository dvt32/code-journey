// https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> charFrequencies = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int frequencyCount = charFrequencies.getOrDefault(c, 0);
            charFrequencies.put(c, frequencyCount+1);
        }
        
        StringBuilder sb = new StringBuilder();
        charFrequencies.entrySet().stream()
            .sorted( Collections.reverseOrder( Map.Entry.comparingByValue() ) )
            .forEach( 
                entry -> {
                    Character key = entry.getKey();
                    Integer value = entry.getValue();
                    for (int i = 0; i < value; ++i) {
                        sb.append(key);   
                    }
                } 
            );
        
        return sb.toString();
    }
    
}
