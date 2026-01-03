// https://leetcode.com/problems/buddy-strings

class Solution {

    fun buddyStrings(s: String, goal: String): Boolean {
        if (s.length != goal.length) {
            return false
        }
        
        if (s == goal) {
            return s.toSet().size < s.length
        }
        
        val mismatchingCharactersIndices = mutableListOf<Int>()
        for (i in s.indices) {
            if (s[i] != goal[i]) {
                mismatchingCharactersIndices.add(i)
            }
        }
        
        return (
            mismatchingCharactersIndices.size == 2 &&
            s[mismatchingCharactersIndices[0]] == goal[mismatchingCharactersIndices[1]] &&
            s[mismatchingCharactersIndices[1]] == goal[mismatchingCharactersIndices[0]]
        )
    }

}
