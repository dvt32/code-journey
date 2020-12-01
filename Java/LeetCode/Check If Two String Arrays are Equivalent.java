// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder firstWord = new StringBuilder();
        for (String str : word1) {
            firstWord.append(str);
        }
        
        StringBuilder secondWord = new StringBuilder();
        for (String str : word2) {
            secondWord.append(str);
        }
            
        return firstWord.toString().equals(secondWord.toString());
    }
    
    /*
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals( String.join("", word2) );
    }
    */
    
}
