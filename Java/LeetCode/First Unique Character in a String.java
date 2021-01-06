// https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution {

    public int firstUniqChar(String s) {
        int[] charFrequencies = new int[26];
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int index = (c - 'a');
            charFrequencies[index]++;
        }
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int index = (c - 'a');
            if (charFrequencies[index] == 1) {
                return i;
            }
        }
        
        return -1;
    }
    
    // Alternative solutions below
    
    /*
    public int firstUniqChar(String s) {
        Map<Character, Integer> charFrequencies = new LinkedHashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int frequencies = charFrequencies.getOrDefault(c, 0);
            charFrequencies.put(c, frequencies + 1);
        }
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int frequencies = charFrequencies.get(c);
            if (frequencies == 1) {
                return i;
            }
        }
        
        return -1;
    }
    */

    /*
    public int firstUniqChar(String s) {
        Map<Character, List<Integer>> charIndices = new LinkedHashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            List<Integer> indices = charIndices.getOrDefault(c, new ArrayList<>());
            indices.add(i);
            charIndices.put(c, indices);
        }
        
        for (Character c : charIndices.keySet()) {
            List<Integer> indices = charIndices.get(c);
            if (indices.size() == 1) {
                return indices.get(0);
            }
        }
        
        return -1;
    }
    */
    
}
