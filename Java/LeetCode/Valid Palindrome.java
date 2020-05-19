// https://leetcode.com/problems/valid-palindrome/

class Solution {
    
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        
        s = sb.toString().toLowerCase();
        
        return s.equals( new StringBuilder(s).reverse().toString() );
    }
    
}
