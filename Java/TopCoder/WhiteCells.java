// https://community.topcoder.com/stat?c=problem_statement&pm=8204

public class WhiteCells {
	public static int countOccupied(String[] board) {
		int occupiedWhiteCellsCount = 0;
			
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length(); ++j) {
				boolean elementOnEvenRowAndEvenColumn = (i % 2 == 0 && j % 2 == 0);
				boolean elementOnOddRowAndOddColumn = (i % 2 == 1 && j % 2 == 1);
				if ((elementOnEvenRowAndEvenColumn || elementOnOddRowAndOddColumn) && board[i].charAt(j) == 'F') {
					occupiedWhiteCellsCount++;
				}
			}
		}
		
		return occupiedWhiteCellsCount;
	}
}
