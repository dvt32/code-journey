// https://leetcode.com/problems/find-words-containing-character/

class Solution {
  
    fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        var indices = arrayListOf<Int>();

        for (i in 0 until words.size) {
            if (words[i].contains("" + x)) {
                indices.add(i);
            }
        }

        return indices;
    }
    
}
