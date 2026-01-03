// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

class Solution {
  
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        Set<Character> diffCharsA = new HashSet<Character>();
        Set<Character> diffCharsB = new HashSet<Character>();

        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
                diffCharsA.add(s1.charAt(i));
                diffCharsB.add(s2.charAt(i));
            }
        }

        return (count == 0 || (count == 2 && diffCharsA.equals(diffCharsB)));
    }
  
}
