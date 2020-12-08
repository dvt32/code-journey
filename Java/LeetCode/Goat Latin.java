// https://leetcode.com/problems/goat-latin/

class Solution {

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            char firstLetter = word.charAt(0);
            
            if ( isVowel(firstLetter) ) {
                output.append(word + "ma");
            }
            else {
                output.append(word.substring(1) + firstLetter + "ma");
            }
            
            for (int j = 0; j <= i; ++j) {
                output.append("a");
            }
            
            if (i != words.length-1) {
                output.append(" ");
            }
        }
        
        return output.toString();
    }
    
    public boolean isVowel(char c) {
        return (
            c == 'a' || c == 'A' || 
            c == 'e' || c == 'E' ||
            c == 'i' || c == 'I' ||
            c == 'o' || c == 'O' ||
            c == 'u' || c == 'U'
        );
    }
    
}
