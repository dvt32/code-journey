// https://leetcode.com/problems/alternating-groups-i/

class Solution {

    fun numberOfAlternatingGroups(colors: IntArray): Int {
        var altGroupCount = 0;
        val n = colors.size;

        if (colors[0] == colors[n-2] && colors[n-1] != colors[0]) {
            altGroupCount++;
        }
        if (colors[n-1] == colors[1] && colors[0] != colors[1]) {
            altGroupCount++;
        }
        for (i in 1 until n-1) {
            if (colors[i-1] == colors[i+1] && colors[i] != colors[i-1]) {
                altGroupCount++;
            }
        }

        return altGroupCount;
    }

}
