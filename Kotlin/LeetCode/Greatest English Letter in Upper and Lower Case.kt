// https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/

class Solution {

    fun greatestLetter(s: String): String {
        val uniqueChars = mutableSetOf<Char>();

        s.forEach { uniqueChars.add(it) }

        for (c in 'Z' downTo 'A') {
            if (uniqueChars.contains(c) && uniqueChars.contains(c.lowercaseChar())) {
                return c.toString();
            }
        }

        return "" 
    }

}
