// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class Solution {

    public String removeDuplicates(String S) {
        boolean foundAdjacentDuplicates;
        
        do {
            foundAdjacentDuplicates = false;
            for (int i = 0; i < S.length()-1; ++i) {
                if (S.charAt(i) == S.charAt(i+1)) {
                    S = S.substring(0, i) + S.substring(i+2);
                    foundAdjacentDuplicates = true;
                    break;
                }
            }
        }
        while (foundAdjacentDuplicates);
        
        return S;
    }
    
}
