// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal

/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var areAlmostEqual = function(s1, s2) {
    let count = 0;
    let diffCharsA = new Set();
    let diffCharsB = new Set();

    for (let i = 0; i < s1.length; ++i) {
        if (s1.charAt(i) != s2.charAt(i)) {
            count++;
            if (count > 2) {
                return false;
            }
            diffCharsA.add(s1.charAt(i));
            diffCharsB.add(s2.charAt(i));
        }
    }

    return (count == 0 || (count == 2 && diffCharsA.symmetricDifference(diffCharsB).size == 0));
};
