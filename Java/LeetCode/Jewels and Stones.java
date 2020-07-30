// https://leetcode.com/problems/jewels-and-stones/

class Solution {
    
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        
        Set<Character> jSet = new HashSet<>();
        for (char c : J.toCharArray()) {
            jSet.add(c);
        }
        
        for (char c : S.toCharArray()) {
            if (jSet.contains(c)) {
                result++;
            }
        }
        
        return result;
    }
    
    // Supposedly slower solution with String.contains()
    /*
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        
        for (int i = 0; i < S.length(); ++i) {
            if ( J.contains(String.valueOf(S.charAt(i))) ) {
                result++;
            }
        }
        
        return result;
    }
    */
    
}
