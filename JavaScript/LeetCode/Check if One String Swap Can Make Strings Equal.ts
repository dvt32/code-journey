// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal

function areAlmostEqual(s1: string, s2: string): boolean {
    let count = 0;
    let diffCharsA = new Set<string>();
    let diffCharsB = new Set<string>();

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

    return (count == 0 || (count == 2 && diffCharsA.size === diffCharsB.size && [...diffCharsA].every(x => diffCharsB.has(x))));
};
