// https://leetcode.com/problems/buddy-strings

/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
var buddyStrings = function(s, goal) {
    if (s.length !== goal.length) {
        return false;
    }
    
    if (s === goal) {
        return new Set(s).size < s.length;
    }
    
    let mismatchingCharactersIndices = [];
    for (let i = 0; i < s.length; ++i) {
        if (s[i] !== goal[i]) {
            mismatchingCharactersIndices.push(i)
        }
    }
    
    return (
        mismatchingCharactersIndices.length === 2 &&
        s[mismatchingCharactersIndices[0]] === goal[mismatchingCharactersIndices[1]] &&
        s[mismatchingCharactersIndices[1]] === goal[mismatchingCharactersIndices[0]]
    )
};
