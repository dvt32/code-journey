// https://leetcode.com/problems/ransom-note/

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> noteLetterFrequencies = new HashMap<>();
        Map<Character, Integer> magazineLetterFrequencies = new HashMap<>();
        
        for (int i = 0; i < ransomNote.length(); ++i) {
            char c = ransomNote.charAt(i);
            noteLetterFrequencies.put(
                c,
                noteLetterFrequencies.getOrDefault(c, 0) + 1
            );
        }
        
        for (int i = 0; i < magazine.length(); ++i) {
            char c = magazine.charAt(i);
            magazineLetterFrequencies.put(
                c,
                magazineLetterFrequencies.getOrDefault(c, 0) + 1
            );
        }
        
        for (Character letter : noteLetterFrequencies.keySet()) {
            if (!magazineLetterFrequencies.containsKey(letter) || noteLetterFrequencies.get(letter) > magazineLetterFrequencies.get(letter)) {
                return false;
            }
        }
        
        return true;
    }
    
}
