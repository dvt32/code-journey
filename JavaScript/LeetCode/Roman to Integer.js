// https://leetcode.com/problems/roman-to-integer

/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    let num = 0;

    for (let i = 0; i < s.length; ++i) {
        let val = value(s.charAt(i));
        if (i+1 < s.length && val < value(s.charAt(i+1))) {
            num -= val;
        } else {
            num += val;
        }
    }

    return num;
};

var value = function(c) {
    return {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }[c] ?? 0;
}
