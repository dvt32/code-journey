// https://leetcode.com/problems/calculate-digit-sum-of-a-string

class Solution {

    fun digitSum(s: String, k: Int): String {
        if (s.length <= k) {
            return s
        }

        val newStr = StringBuilder()
        for (i in 0 until s.length step k) {
            val group = s.substring(i, Math.min(s.length, i+k))

            var sum = 0
            for (j in 0 until group.length) {
                sum += Character.getNumericValue(group[j])
            }

            newStr.append(sum.toString())
        }

        return digitSum(newStr.toString(), k)
    }

}
