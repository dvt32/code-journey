// https://leetcode.com/problems/reverse-prefix-of-word/

/**
 * @param {string} word
 * @param {character} ch
 * @return {string}
 */
var reversePrefix = function(word, ch) {
    let chIndex = word.indexOf(ch);
    if (chIndex == -1) {
        return word;
    }

    return word.substring(0, chIndex+1).split('').reverse().join('') + word.substring(chIndex+1);
};
