// https://leetcode.com/problems/matrix-diagonal-sum/

class Solution {
    
    public int diagonalSum(int[][] mat) {
        int diagonalSum = 0;
        
        // Get primary diagonal sum
        for (int rowIndex = 0, colIndex = 0; 
             rowIndex < mat.length; 
             ++rowIndex, ++colIndex) 
        {
            diagonalSum += mat[rowIndex][colIndex];
        }
        
        // Get secondary diagonal sum
        for (int rowIndex = 0, colIndex = mat.length-1; 
             rowIndex < mat.length; 
             ++rowIndex, --colIndex) 
        {
            diagonalSum += mat[rowIndex][colIndex];
        }
        
        // Exclude duplicate element if diagonals cross paths
        if (mat.length % 2 == 1) {
            diagonalSum -= mat[mat.length/2][mat.length/2];
        }
        
        return diagonalSum;
    }
    
}
