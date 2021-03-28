// https://leetcode.com/problems/happy-number/

class Solution {
    
    public boolean isHappy(int n) {
        Set<Integer> nValues = new HashSet<>();
        
        while (!nValues.contains(n) && n != 1) {
            nValues.add(n);
            
            String num = String.valueOf(n);
            
            n = 0;
            for (int i = 0; i < num.length(); ++i) {
                int digit = Character.getNumericValue( num.charAt(i) );
                n += digit*digit;
            }
        }
        
        return (n == 1);
    }
    
}
