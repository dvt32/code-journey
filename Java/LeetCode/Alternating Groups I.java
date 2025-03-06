// https://leetcode.com/problems/alternating-groups-i/

class Solution {

    public int numberOfAlternatingGroups(int[] colors) {
        int altGroupCount = 0;
        int n = colors.length;

        if (colors[0] == colors[n-2] && colors[n-1] != colors[0]) {
            altGroupCount++;
        }
        if (colors[n-1] == colors[1] && colors[0] != colors[1]) {
            altGroupCount++;
        }
        for (int i = 1; i < n-1; ++i) {
            if (colors[i-1] == colors[i+1] && colors[i] != colors[i-1]) {
                altGroupCount++;
            }
        }

        return altGroupCount;
    }

}
