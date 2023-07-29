// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game

class Solution {

    public String tictactoe(int[][] moves) {
        char[][] grid = new char[3][3];

        for (int i = 0; i < moves.length; ++i) {
            int row = moves[i][0];
            int col = moves[i][1];
            grid[row][col] = (i % 2 == 0) ? 'X' : 'O';
        }

        if (isWinner('A', grid)) {
            return "A";
        } else if (isWinner('B', grid)) {
            return "B";
        }
        
        return (moves.length == 9) ? "Draw" : "Pending";
    }

    public static boolean isWinner(char player, char[][] grid) {
        char playerSymbol = (player == 'A') ? 'X' : 'O';

        return 
         // 3 horizontal
         (grid[0][0] == playerSymbol && grid[0][0] == grid[0][1] && grid[0][0] == grid[0][2]) ||
         (grid[1][0] == playerSymbol && grid[1][0] == grid[1][1] && grid[1][0] == grid[1][2]) ||
         (grid[2][0] == playerSymbol && grid[2][0] == grid[2][1] && grid[2][0] == grid[2][2]) ||
         // 3 vertical
         (grid[0][0] == playerSymbol && grid[0][0] == grid[1][0] && grid[0][0] == grid[2][0]) ||
         (grid[0][1] == playerSymbol && grid[0][1] == grid[1][1] && grid[0][1] == grid[2][1]) ||
         (grid[0][2] == playerSymbol && grid[0][2] == grid[1][2] && grid[0][2] == grid[2][2]) ||
         // left diagonal
         (grid[0][0] == playerSymbol && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) ||
         // right diagonal
         (grid[0][2] == playerSymbol && grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]);
    }

}
