// https://leetcode.com/problems/faulty-keyboard

class Solution {
    fun finalString(s: String): String {
        val finalStr = StringBuilder();

        for (c in s) {
            if (c == 'i') {
                finalStr.reverse();
            } else {
                finalStr.append(c);
            }
        }

        return finalStr.toString();
    }
}
