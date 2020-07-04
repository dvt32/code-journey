// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

class Solution {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        Map<Integer, Integer> rowMinNumbers = new HashMap<>();
        Map<Integer, Integer> colMaxNumbers = new HashMap<>();
        
        for (int rowIndex = 0; rowIndex < matrix.length; ++rowIndex) {
            int minNumberOnRow = Integer.MAX_VALUE;
            for (int colIndex = 0; colIndex < matrix[rowIndex].length; ++colIndex) {
                minNumberOnRow = Math.min(matrix[rowIndex][colIndex], minNumberOnRow);
            }
            rowMinNumbers.put(rowIndex, minNumberOnRow);
        }
        
        for (int colIndex = 0; colIndex < matrix[0].length; ++colIndex) {
            int maxNumberOnCol = Integer.MIN_VALUE;
            for (int rowIndex = 0; rowIndex < matrix.length; ++rowIndex) {
                maxNumberOnCol = Math.max(matrix[rowIndex][colIndex], maxNumberOnCol);
            }
            colMaxNumbers.put(colIndex, maxNumberOnCol);
        }
        
        for (int rowIndex = 0; rowIndex < matrix.length; ++rowIndex) {
            for (int colIndex = 0; colIndex < matrix[rowIndex].length; ++colIndex) {
                int minNumberOnRow = rowMinNumbers.get(rowIndex);
                int maxNumberOnCol = colMaxNumbers.get(colIndex);
                int currentNumber = matrix[rowIndex][colIndex];
                if (currentNumber == minNumberOnRow && currentNumber == maxNumberOnCol) {
                    luckyNumbers.add(currentNumber);
                }
            }
        }
        
        return luckyNumbers;
    }
    
}
