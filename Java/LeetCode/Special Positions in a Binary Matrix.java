// https://leetcode.com/problems/special-positions-in-a-binary-matrix/

class Solution {

    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        
        int numberOfSpecialPositions = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    numberOfSpecialPositions++;
                }
            }
        }
        
        return numberOfSpecialPositions;
    }
    
}
