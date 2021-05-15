// https://leetcode.com/problems/replace-all-digits-with-characters/

class Solution {

    public String replaceDigits(String s) {
        StringBuilder output = new StringBuilder(s);
        
        for (int i = 1; i < s.length(); i += 2) {
            char letter = s.charAt(i-1);
            int digit = Character.getNumericValue( s.charAt(i) );
            output.setCharAt(i, (char) (letter + digit));
        }
        
        return output.toString();
    }
    
}
