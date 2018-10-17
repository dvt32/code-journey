// http://codeforces.com/problemset/problem/275/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		char[][] lightsGrid = new char[][] {
			new char[] { '1', '1', '1' },
			new char[] { '1', '1', '1' },
			new char[] { '1', '1', '1' }
		};
		
		int[][] toggles = new int[3][3];
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				toggles[i][j] = read.nextInt();
				for (int k = 0; k < toggles[i][j]; ++k) {
					// toggle cell
					lightsGrid[i][j] = (lightsGrid[i][j] == '1') ? '0' : '1';
					
					// top cell toggle
					if (i-1 >= 0) {
						lightsGrid[i-1][j] = (lightsGrid[i-1][j] == '1') ? '0' : '1';
					}
					
					// bottom cell toggle
					if (i+1 < 3) {
						lightsGrid[i+1][j] = (lightsGrid[i+1][j] == '1') ? '0' : '1';
					}
					
					// left cell toggle
					if (j-1 >= 0) {
						lightsGrid[i][j-1] = (lightsGrid[i][j-1] == '1') ? '0' : '1';
					}
					
					// right cell toggle
					if (j+1 < 3) {
						lightsGrid[i][j+1] = (lightsGrid[i][j+1] == '1') ? '0' : '1';
					}
				}
			}
		}
		
		for (char[] row : lightsGrid) {
			System.out.println(row);
		}
		
		// Close scanner
		read.close();
	}

}
