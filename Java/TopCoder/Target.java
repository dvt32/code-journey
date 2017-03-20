// https://community.topcoder.com/stat?c=problem_statement&pm=13462

public class Target {
	public static String[] draw(int n) {
		char[][] drawingMatrix = new char[n][n];
		String[] drawing = new String[n];
		
		// Fill matrix with spaces beforehand
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				drawingMatrix[i][j] = ' ';
			}
		}
		
		int rowIndex = 0;
		int colIndex = 0;
		int minRowIndex = 0;
		int minColIndex = 0;
		int maxRowIndex = n-1;
		int maxColIndex = n-1;
		
		// Fill matrix with '#' where needed
		int loopCount = 0;
		while (loopCount < n) {
			// Fill row from left to right (→)
			while (colIndex <= maxColIndex) {
				drawingMatrix[rowIndex][colIndex] = '#';
				colIndex++;
			} colIndex--;
			
			// Fill column from top to bottom (↓)
			while (rowIndex <= maxRowIndex) {
				drawingMatrix[rowIndex][colIndex] = '#';
				rowIndex++;
			} rowIndex--;
			
			// Fill row from right to left (←)
			while (colIndex >= minColIndex) {
				drawingMatrix[rowIndex][colIndex] = '#';
				colIndex--;
			} colIndex++;
			
			// Fill column from bottom to top (↑)
			while (rowIndex >= minRowIndex) {
				drawingMatrix[rowIndex][colIndex] = '#';
				rowIndex--;
			} rowIndex++;
			
			// Prepare for next iteration (next nested square)
			rowIndex += 2;
			colIndex += 2;
			minRowIndex += 2;
			minColIndex += 2;
			maxRowIndex -= 2;
			maxColIndex -= 2;
			
			loopCount++;
		}
		
		// Convert drawingMatrix to String array
		for (int i = 0; i < drawingMatrix.length; ++i) {
			drawing[i] = String.valueOf( drawingMatrix[i] );
		}
		
		return drawing;
	}
}
