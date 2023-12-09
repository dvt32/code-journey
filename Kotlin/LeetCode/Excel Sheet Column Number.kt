// https://leetcode.com/problems/excel-sheet-column-title

class Solution {

    fun titleToNumber(columnTitle: String): Int {
        var number = 0

        for (i in 0 until columnTitle.length) {
            number *= 26;
            number += (columnTitle[i] - 'A' + 1);
        }

        return number
    }

}
