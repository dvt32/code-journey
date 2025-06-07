// https://leetcode.com/problems/reverse-words-in-a-string

function reverseWords(s: string): string {
    return s.trim().split(/ +/).reverse().join(" ");
};
