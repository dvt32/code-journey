// https://leetcode.com/problems/reverse-degree-of-a-string/

function reverseDegree(s: string): number {
    let sum = 0;

    for (let i = 0; i < s.length; ++i) {
        sum += (26 - (s.charCodeAt(i) - 'a'.charCodeAt(0))) * (i+1);
    }

    return sum;
};
