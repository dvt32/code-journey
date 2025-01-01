// https://leetcode.com/problems/count-the-number-of-special-characters-i/

class Solution {

    fun numberOfSpecialChars(word: String): Int {
        val lowercaseChars = mutableSetOf<Char>();
        val uppercaseChars = mutableSetOf<Char>();

        word.forEach {
            if (it.isLowerCase()) {
                lowercaseChars.add(it);
            } else {
                uppercaseChars.add(it);
            }
        }

        var specialCount = 0;
        lowercaseChars.forEach {
            if (uppercaseChars.contains(it.toUpperCase())) {
                specialCount++;
            }
        }

        return specialCount;
    }
    
}
