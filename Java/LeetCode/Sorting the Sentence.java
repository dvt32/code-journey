// https://leetcode.com/problems/sorting-the-sentence/

class Solution {

    public String sortSentence(String s) {
        String[] shuffledWords = s.split(" ");
        String[] words = new String[shuffledWords.length];
        
        for (String shuffledWord : shuffledWords) {
            int positionIndex = shuffledWord.length()-1;
            int position = Character.getNumericValue(shuffledWord.charAt(positionIndex)) - 1;
            words[position] = shuffledWord.substring(0, positionIndex);
        }
        
        return String.join(" ", words);
    }
    
}
