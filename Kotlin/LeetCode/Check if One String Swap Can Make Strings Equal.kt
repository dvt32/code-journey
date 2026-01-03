// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal

class Solution {

    fun areAlmostEqual(s1: String, s2: String): Boolean {
        var count = 0;
        var diffCharsA = mutableSetOf<Char>();
        var diffCharsB = mutableSetOf<Char>();

        for (i in 0 until s1.length) {
            if (s1[i] != s2[i]) {
                count++;
                if (count > 2) {
                    return false;
                }
                diffCharsA.add(s1[i]);
                diffCharsB.add(s2[i]);
            }
        }

        return (count == 0 || (count == 2 && diffCharsA.equals(diffCharsB)));
    }

}
