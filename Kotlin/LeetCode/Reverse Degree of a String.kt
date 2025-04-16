// https://leetcode.com/problems/reverse-degree-of-a-string/

class Solution {

    fun reverseDegree(s: String): Int {
        var reverseDegree = 0;

        for (i in 0 until s.length) {
            reverseDegree += (26 - (s[i] - 'a')) * (i+1);
        }

        return reverseDegree;
    }

}
