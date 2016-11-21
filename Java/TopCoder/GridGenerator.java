// https://community.topcoder.com/stat?c=problem_statement&pm=4688

public class GridGenerator {
	public static int generate(int[] row, int[] col) {
		int[][] arr = new int[col.length][row.length];
		
		arr[0] = row;
		for (int i = 1; i < col.length; ++i) {
			arr[i][0] = col[i];
		}
		
		
		for (int i = 1; i < arr.length; ++i) {
			for (int j = 1; j < arr[i].length; ++j) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j-1] + arr[i-1][j];
			}
		}
		
		int lowerRightValue = arr[arr.length-1][arr[0].length-1];
		
		return lowerRightValue;
	}
}
