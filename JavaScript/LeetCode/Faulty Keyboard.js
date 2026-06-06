// https://leetcode.com/problems/faulty-keyboard

/**
 * @param {string} s
 * @return {string}
 */
var finalString = function(s) {
    let finalStr = [];

    for (const c of s) {
        if (c === 'i') {
            finalStr.reverse();
        } else {
            finalStr.push(c);
        }
    }

    return finalStr.join("");
};

// Alternative solution
/*
var finalString = function(s) {
    let finalStr = "";

    for (const c of s) {
        if (c === 'i') {
            finalStr = finalStr.split("").reverse().join("");
        } else {
            finalStr += c;
        }
    }

    return finalStr;
};
*/
