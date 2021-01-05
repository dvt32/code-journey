// https://leetcode.com/problems/make-the-string-great/

class Solution {
    
    public String makeGood(String s) {
        if (s.length() == 0) {
            return s;
        }
        
        int n;
        do {
            StringBuilder sb = new StringBuilder();
            n = s.length();
            int i = 0;
            
            while (i < n) {
                char currentChar = s.charAt(i);
                char nextChar = (i < n-1) ? s.charAt(i+1) : ' ';

                if (Character.toLowerCase(currentChar) == Character.toLowerCase(nextChar) && 
                    (
                        (Character.isLowerCase(currentChar) && Character.isUpperCase(nextChar)) ||
                        (Character.isUpperCase(currentChar) && Character.isLowerCase(nextChar)) 
                    )
                   ) 
                {
                    i += 2;
                }
                else {
                    sb.append(currentChar);
                    i++;
                }
            }
        
            s = sb.toString();
        }
        while (s.length() != n);
        
        return s;
    }
    
}
