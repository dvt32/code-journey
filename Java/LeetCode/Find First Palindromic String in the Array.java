// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

class Solution {
    
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            if ( word.equals(reversedWord) ) {
                return word;
            }
        }
        
        return "";
    }
    
}
