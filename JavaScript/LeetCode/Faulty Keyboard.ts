// https://leetcode.com/problems/faulty-keyboard

function finalString(s: string): string {
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
function finalString(s: string): string {
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
