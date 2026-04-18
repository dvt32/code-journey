// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {

    final Set<Character> VOWELS = Set.of('a','e','i','o','u','A','E','I','O','U');

    public String reverseVowels(String s) {
        Stack<Character> vowels = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (VOWELS.contains(c)) {
                vowels.push(c);
            }
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (VOWELS.contains(c)) {
                output.append(vowels.pop());
            } else {
                output.append(c);
            }
        }

        return output.toString();
    }

}
