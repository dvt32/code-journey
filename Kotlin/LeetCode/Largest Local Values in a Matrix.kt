// https://leetcode.com/problems/largest-local-values-in-a-matrix

class Solution {

    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        var n = grid.size;
        var maxLocal = Array(n-2) { IntArray(n-2) }

        for (i in 0 until maxLocal.size) {
            for (j in 0 until maxLocal[i].size) {
                for (k in i..i+2) {
                    for (m in j..j+2) {
                        maxLocal[i][j] = Math.max(maxLocal[i][j], grid[k][m]);
                    }
                }
            }
        }

        return maxLocal;
    }
    
}
