// https://leetcode.com/problems/verifying-an-alien-dictionary/

class Solution {
    
    Map<Character, Integer> alienLetterIndices = new HashMap<>();
    
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); ++i) {
            char c = order.charAt(i);
            alienLetterIndices.put(c, i);
        }
        
        for (int i = 0; i < words.length-1; ++i) {
            if (!areInSortedOrder(words[i], words[i+1])) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean areInSortedOrder(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        
        for (int i = 0; i < minLength; ++i) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);
            if (aChar != bChar) {
                int aCharIndex = alienLetterIndices.get(aChar);
                int bCharIndex = alienLetterIndices.get(bChar);
                return (aCharIndex > bCharIndex) ? false : true;
            }
        }

        return (a.length() > b.length()) ? false : true;
    }
    
}
