// https://leetcode.com/problems/excel-sheet-column-title

class Solution {

    public int titleToNumber(String columnTitle) {
        int number = 0;

        for (int i = 0; i < columnTitle.length(); ++i) {
            number *= 26;
            number += (columnTitle.charAt(i) - 'A' + 1);
        }

        return number;
    }

}
