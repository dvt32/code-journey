// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/

class Solution {

    fun largestInteger(num: Int): Int {
        val numChars = num.toString()
        val isEvenDigit = BooleanArray(numChars.length)
        val evenDigits = arrayListOf<Int>()
        val oddDigits = arrayListOf<Int>()

        for (i in 0 until numChars.length) {
            val digit = numChars[i].digitToInt();
            if (digit % 2 == 0) {
                evenDigits.add(digit)
                isEvenDigit[i] = true
            } else {
                oddDigits.add(digit)
                isEvenDigit[i] = false
            }
        }

        evenDigits.sortDescending()
        oddDigits.sortDescending()

        val sb = StringBuilder()
        var j = 0
        var k = 0
        for (i in 0 until numChars.length) {
            if (isEvenDigit[i]) {
                sb.append(evenDigits[j++])
            } else {
                sb.append(oddDigits[k++])
            }
        }

        return sb.toString().toInt()
    }

}
