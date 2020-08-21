// https://leetcode.com/problems/shortest-completing-word/

class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> licensePlateCharFrequencies = new HashMap<>();
        licensePlate = licensePlate.toLowerCase();
       
        for (int i = 0; i < licensePlate.length(); ++i) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                licensePlateCharFrequencies.put(c, licensePlateCharFrequencies.getOrDefault(c,0)+1);   
            }
        }
        
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        
        for (String word : words) {
            Map<Character, Integer> wordCharFrequencies = new HashMap<>();
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                wordCharFrequencies.put(c, wordCharFrequencies.getOrDefault(c,0)+1);
            }
            
            boolean isCompletingWord = true;
            for (Character c : licensePlateCharFrequencies.keySet()) {
                if (!wordCharFrequencies.containsKey(c) || 
                     wordCharFrequencies.get(c) < licensePlateCharFrequencies.get(c))
                {
                    isCompletingWord = false;
                    break;
                }
            }
            
            if (isCompletingWord) {
                return word;
            }
        }
        
        return null;
    }
    
}
