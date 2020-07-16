// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

class Solution {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        
        for (int[] index : indices) {
            int ri = index[0];
            int ci = index[1];
            for (int i = 0; i < m; ++i) {
                matrix[ri][i]++;
            }
            for (int i = 0; i < n; ++i) {
                matrix[i][ci]++;
            }
        }
        
        int oddValueCount = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] % 2 == 1) {
                    oddValueCount++;
                }
            }
        }
        
        return oddValueCount;
    }
    
}
