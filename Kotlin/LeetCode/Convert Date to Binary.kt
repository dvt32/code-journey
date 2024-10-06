// https://leetcode.com/problems/convert-date-to-binary/

class Solution {
    
    fun convertDateToBinary(date: String) = date.split("-").map { it.toInt().toString(2) }.joinToString("-")

    // Alternative
    /*
    fun convertDateToBinary(date: String): String {
        var parts = date.split("-").toMutableList()

        for (i in parts.indices) {
            parts[i] = parts[i].toInt().toString(2)
        }

        return parts.joinToString("-")
    }
    */

}
