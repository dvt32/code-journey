// https://leetcode.com/problems/available-captures-for-rook/

class Solution {

    public int numRookCaptures(char[][] board) {
        int rookRowIndex = 0;
        int rookColIndex = 0;
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'R') {
                    rookRowIndex = i;
                    rookColIndex = j;
                    break;
                }
            }
        }
        
        int numberOfPossiblePawnCaptures = 0;
        
        // Move rook left
        for (int i = rookColIndex-1; i > 0; --i) {
            if (board[rookRowIndex][i] == 'p') {
                numberOfPossiblePawnCaptures++;
                break;
            }
            else if (board[rookRowIndex][i] == 'B') {
                break;
            }
        }
        
        // Move rook right
        for (int i = rookColIndex+1; i < board.length; ++i) {
            if (board[rookRowIndex][i] == 'p') {
                numberOfPossiblePawnCaptures++;
                break;
            }
            else if (board[rookRowIndex][i] == 'B') {
                break;
            }
        }
        
        // Move rook up
        for (int i = rookRowIndex-1; i > 0; --i) {
            if (board[i][rookColIndex] == 'p') {
                numberOfPossiblePawnCaptures++;
                break;
            }
            else if (board[i][rookColIndex] == 'B') {
                break;
            }
        }
        
        // Move rook down
        for (int i = rookRowIndex+1; i < board.length; ++i) {
            if (board[i][rookColIndex] == 'p') {
                numberOfPossiblePawnCaptures++;
                break;
            }
            else if (board[i][rookColIndex] == 'B') {
                break;
            }
        }
        
        return numberOfPossiblePawnCaptures;
    }
    
}
