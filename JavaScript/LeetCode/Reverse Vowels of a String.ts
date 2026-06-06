// https://leetcode.com/problems/reverse-vowels-of-a-string

function reverseVowels(s: string): string {
    let vowels = [];

    for (const c of s) {
        if (VOWELS.has(c)) {
            vowels.push(c);
        }
    }

    let output = "";

    for (const c of s) {
        if (VOWELS.has(c)) {
            output += vowels.pop();
        } else {
            output += c;
        }
    }

    return output;
};

const VOWELS = new Set([
    'a','e','i','o','u','A','E','I','O','U'
]);
