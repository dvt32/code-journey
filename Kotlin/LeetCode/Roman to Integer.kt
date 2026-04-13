// https://leetcode.com/problems/roman-to-integer

class Solution {
  
    fun romanToInt(s: String): Int {
        var num = 0;

        for (i in 0 until s.length) {
            val charVal = value(s[i])
            if (i+1 < s.length && charVal < value(s[i+1])) {
                num -= charVal
            } else {
                num += charVal
            }
        }

        return num
    }

    fun value(c: Char): Int = when (c) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D'-> 500
        'M' -> 1000
        else -> 0
    };
  
}
