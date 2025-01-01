// https://leetcode.com/problems/count-the-number-of-special-characters-i/

class Solution {

    public int numberOfSpecialChars(String word) {
        Set<Character> lowercaseChars = new HashSet<>();
        Set<Character> uppercaseChars = new HashSet<>();

        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lowercaseChars.add(c);
            } else {
                uppercaseChars.add(c);
            }
        }

        int specialCount = 0;
        for (Character c : lowercaseChars) {
            if (uppercaseChars.contains(Character.toUpperCase(c))) {
                specialCount++;
            }
        }

        return specialCount;
    }
  
}
