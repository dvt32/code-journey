// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game

class Solution {

    fun tictactoe(moves: Array<IntArray>): String {
        val grid = Array(3) { CharArray(3) }

        for (i in 0 until moves.size) {
            val row = moves[i][0]
            val col = moves[i][1]
            grid[row][col] = if (i % 2 == 0) 'X' else 'O'
        }

        return when {
            isWinner('A', grid) -> "A"
            isWinner('B', grid) -> "B"
            moves.size == 9 -> "Draw"
            else -> "Pending"
        }
    }

    fun isWinner(player: Char, grid: Array<CharArray>): Boolean {
        val playerSymbol = if (player == 'A') 'X' else 'O'

        return (
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
        (grid[0][2] == playerSymbol && grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]) )
    }

}
