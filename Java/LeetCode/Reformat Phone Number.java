// https://leetcode.com/problems/reformat-phone-number/

import java.util.StringJoiner;

class Solution {
    
    public String reformatNumber(String number) {
        if (number.length() == 2) {
            return number;
        }
        
        number = number.replaceAll("[ -]", "");
        
        StringJoiner joiner = new StringJoiner("-");
        int i = 0;
        int n = number.length();
        while (i < n-4) {
            joiner.add( number.substring(i, i+3) );
            i += 3;
        }
        
        int numberOfUnusedDigits = number.length() - i;
        if (numberOfUnusedDigits == 2 || numberOfUnusedDigits == 3) {
            joiner.add( number.substring(i, n) );
        }
        else {
            joiner.add( number.substring(i, n-2));
            i += 2;
            joiner.add( number.substring(i, n));
        }
        
        return joiner.toString();
    }
    
}
