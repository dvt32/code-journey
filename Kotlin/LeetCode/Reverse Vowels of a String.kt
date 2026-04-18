// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {

    val VOWELS = setOf<Char>('a','e','i','o','u','A','E','I','O','U');

    fun reverseVowels(s: String): String {
        val vowels = ArrayDeque<Char>()

        for (c in s) {
            if (c in VOWELS) {
                vowels.addLast(c);
            }
        }

        val output = StringBuilder();

        for (c in s) {
            if (c in VOWELS) {
                output.append(vowels.removeLast());
            } else {
                output.append(c);
            }
        }

        return output.toString();
    }
    
}
