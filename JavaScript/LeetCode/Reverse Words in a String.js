// https://leetcode.com/problems/reverse-words-in-a-string/

/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    return s.trim().split(/ +/).reverse().join(" ");
};
