// https://leetcode.com/problems/number-of-different-integers-in-a-string/

class Solution {

    fun numDifferentIntegers(word: String): Int {
        val nums = word.split("\\D+".toRegex()) // or "[a-z]+"
        val uniqueNums = mutableSetOf<BigInteger>()

        nums.forEach {
            if (!it.isEmpty()) {
                uniqueNums.add(BigInteger(it))
            }
        }

        return uniqueNums.size
    }

}
