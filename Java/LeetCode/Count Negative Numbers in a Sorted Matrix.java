// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

class Solution {

    public int countNegatives(int[][] grid) {
        int negativeNumberCount = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] < 0) {
                    negativeNumberCount++;
                }
            }
        }
        
        return negativeNumberCount;
    }
    
}
