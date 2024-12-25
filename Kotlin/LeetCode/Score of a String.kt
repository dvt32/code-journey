// https://leetcode.com/problems/score-of-a-string/

class Solution {

    fun scoreOfString(s: String): Int {
        var score = 0

        for (i in 0 until s.length-1) {
            score += abs(s[i].toInt() - s[i+1].toInt())
        }

        return score
    }
    
}
