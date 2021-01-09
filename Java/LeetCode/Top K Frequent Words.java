// https://leetcode.com/problems/top-k-frequent-words/

class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordFrequencies = new TreeMap<>();
        
        for (String word : words) {
            int frequencyCount = wordFrequencies.getOrDefault(word, 0);
            wordFrequencies.put(word, frequencyCount+1);
        }
        
        List<String> result = new ArrayList<>();
        wordFrequencies.entrySet().stream()
            .sorted( Collections.reverseOrder( Map.Entry.comparingByValue() ) )
            .limit(k)
            .forEach( entry -> result.add(entry.getKey()) );
        
        return result;
    }
    
}
