// https://community.topcoder.com/stat?c=problem_statement&pm=10299

public class TheSquareDivTwo {
	public static String[] solve(String[] board) {
		// Get number of 'C' characters on each row
		int[] R = new int[board.length];
		for (int i = 0; i < board.length; ++i) {
			R[i] = board[i].replaceAll("\\.", "").length();
		}
		
		// Convert board to 2D char array
		char[][] boardArray = new char[board.length][board.length];
		for (int i = 0; i < board.length; ++i) {
			boardArray[i] = board[i].toCharArray();
		}
		
		// Replace values on each column so that R[i] = number of C's on i-th column
		for (int col = 0; col < board.length; ++col) {
			for (int row = board.length-1; row >= 0; --row) {
				if (R[col] != 0) {
					boardArray[row][col] = 'C';
					R[col]--;
				}
				else {
					boardArray[row][col] = '.';
				}
			}
		}
		
		// Convert modified board array to a String[] board
		String[] newBoard = new String[board.length];
		for (int j = 0; j < board.length; ++j) {
			newBoard[j] = String.valueOf(boardArray[j]);
		}
		
		return newBoard;
	}
}
