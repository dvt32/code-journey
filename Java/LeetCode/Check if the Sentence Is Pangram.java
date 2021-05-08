// https://leetcode.com/problems/check-if-the-sentence-is-pangram/

class Solution {

    public boolean checkIfPangram(String sentence) {
        Set<Character> uniqueLetters = new HashSet<Character>();
        
        for (int i = 0; i < sentence.length(); ++i) {
            char letter = sentence.charAt(i);
            uniqueLetters.add(letter);
        }
        
        return uniqueLetters.size() == 26;
    }
    
}
