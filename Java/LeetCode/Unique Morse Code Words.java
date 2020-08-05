// https://leetcode.com/problems/unique-morse-code-words/

class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        final String[] morseCodeAlphabet = new String[] {
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."
        };
        
        Map<Character, String> letterEncodings = new HashMap<>();
        int letterIndex = 0;
        for (char letter = 'a'; letter <= 'z'; ++letter) {
            letterEncodings.put(letter, morseCodeAlphabet[letterIndex]);
            letterIndex++;
        }
        
        Set<String> uniqueTransformedWords = new HashSet<>();
        for (String word : words) {
            StringBuilder transformedWord = new StringBuilder();
            for (int i = 0; i < word.length(); ++i) {
                transformedWord.append( letterEncodings.get(word.charAt(i)) );
            }
            uniqueTransformedWords.add( transformedWord.toString() );
        }
        
        return uniqueTransformedWords.size();
    }
    
}
