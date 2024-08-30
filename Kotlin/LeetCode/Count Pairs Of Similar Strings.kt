// https://leetcode.com/problems/count-pairs-of-similar-strings/submissions/1373367005

class Solution {
  
    fun similarPairs(words: Array<String>): Int {
        var similarPairCount = 0

        for (i in words.indices) {
            for (j in i + 1 until words.size) {
                val s1 = words[i].toSet()
                val s2 = words[j].toSet()
                if (s1 == s2) {
                    similarPairCount++
                }
            }
        }

        return similarPairCount
    }
    
}

// Alternative solution
/*
class Solution {
  
    fun similarPairs(words: Array<String>): Int {
        var similarPairCount = 0

        for (i in 0 until words.size) {
            for (j in i+1 until words.size) {
                val firstWordChars = mutableSetOf<Char>()
                val secondWordChars = mutableSetOf<Char>()
                for (k in 0 until words[i].length) {
                    firstWordChars.add(words[i][k])
                }
                for (m in 0 until words[j].length) {
                    secondWordChars.add(words[j][m])
                }
                if (firstWordChars.equals(secondWordChars)) {
                    similarPairCount++
                }
            }
        }

        return similarPairCount
    }
    
}
*/
