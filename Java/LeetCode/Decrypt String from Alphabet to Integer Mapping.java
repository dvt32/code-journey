// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

class Solution {

    public String freqAlphabets(String s) {
        StringBuilder output = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (i+2 < s.length() && s.charAt(i+2) == '#') {
                int number = Integer.parseInt( s.substring(i, i+2) );
                output.append( (char) (96 + number) );
                i += 3;
            }
            else {
                int digit = Character.getNumericValue( s.charAt(i) );
                output.append( (char) (96 + digit) );
                i++;
            }
        }
        
        return output.toString();
    }
    
}
