// https://leetcode.com/problems/reverse-prefix-of-word

function reversePrefix(word: string, ch: string): string {
    let chIndex = word.indexOf(ch);
    if (chIndex == -1) {
        return word;
    }

    return word.substring(0, chIndex+1).split('').reverse().join('') + word.substring(chIndex+1);
};
