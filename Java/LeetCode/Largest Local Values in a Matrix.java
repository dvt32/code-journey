// https://leetcode.com/problems/largest-local-values-in-a-matrix

class Solution {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n-2][n-2];

        for (int i = 0; i < maxLocal.length; ++i) {
            for (int j = 0; j < maxLocal[i].length; ++j) {
                for (int k = i; k < i+3; ++k) {
                    for (int m = j; m < j+3; ++m) {
                        maxLocal[i][j] = Math.max(maxLocal[i][j], grid[k][m]);
                    }
                }
            }
        }

        return maxLocal;
    }

}
