// https://leetcode.com/problems/buddy-strings/

class Solution {
    
    public boolean buddyStrings(String A, String B) {
        int aLength = A.length();
        int bLength = B.length();
        
        if (aLength != bLength) {
            return false; // if strings have different lengths, they can't ever be equal, regardless of what chars we switch
        }
        
        if (A.equals(B)) {
            Set<Character> uniqueCharsInA = new HashSet<>();
            for (char c : A.toCharArray()) {
                uniqueCharsInA.add(c);
            }
            boolean thereAreDuplicatesInA = (uniqueCharsInA.size() < aLength);
            if (thereAreDuplicatesInA) {
                return true; // because we can switch the duplicates and then string remains the same
            }
            else {
                return false; // no duplicates, so whatever chars we switch, afterwards A and B will not be equal anymore
            }
        }
        
        List<Integer> mismatchingCharactersIndices = new ArrayList<>();
        for (int i = 0; i < aLength; ++i) {
            char aChar = A.charAt(i);
            char bChar = B.charAt(i);
            if (aChar != bChar) {
                mismatchingCharactersIndices.add(i);
            }
        }
        
        /*
            There must be exatly 2 mismatching characters in A.
            
            The different characters in B must be 
            the same as the different ones in A, 
            but in reverse order.
            
            If that is the case, we simply switch 
            the two mismatching characters in A 
            and now A and B become equal.
        */
        if (mismatchingCharactersIndices.size() == 2 &&
            A.charAt(mismatchingCharactersIndices.get(0)) == B.charAt(mismatchingCharactersIndices.get(1)) &&
            A.charAt(mismatchingCharactersIndices.get(1)) == B.charAt(mismatchingCharactersIndices.get(0))) 
        {
            return true;
        }
        else{
           return false; 
        } 
    }
    
}
