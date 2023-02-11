// https://leetcode.com/problems/increment-submatrices-by-one

class Solution {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];

            for (int x = row1; x <= row2; ++x) {
                for (int y = col1; y <= col2; ++y) {
                    mat[x][y]++;
                }
            }
        }

        return mat;
    }

}
