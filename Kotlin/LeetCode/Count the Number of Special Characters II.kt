// https://leetcode.com/problems/count-the-number-of-special-characters-ii/

class Solution {

    fun numberOfSpecialChars(word: String): Int {
        val lowercaseLastIndices = mutableMapOf<Char, Int>();
        val uppercaseFirstIndices = mutableMapOf<Char, Int>();

        word.forEachIndexed { i, c ->
            if (c.isLowerCase()) {
                lowercaseLastIndices.put(c, i);
            } else {
                uppercaseFirstIndices.putIfAbsent(c, i);
            }
        }

        var specialCount = 0;
        lowercaseLastIndices.forEach {
            if (uppercaseFirstIndices.getOrDefault(it.key.toUpperCase(), -1) > it.value) {
                specialCount++;
            }
        }

        return specialCount
    }

}
