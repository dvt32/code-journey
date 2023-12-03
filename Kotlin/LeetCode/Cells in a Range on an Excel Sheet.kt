// https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet

class Solution {
  
    fun cellsInRange(s: String): List<String> {
        val result = mutableListOf<String>();

        for (r in s[0]..s[3]) {
            for (c in s[1]..s[4]) {
                result.add("" + r + c);
            }
        }

        return result;
    }
    
}
