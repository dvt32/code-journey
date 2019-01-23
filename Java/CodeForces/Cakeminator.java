// https://codeforces.com/problemset/problem/330/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int r = read.nextInt();
		int c = read.nextInt();
		
		read.nextLine();
		
		char[][] grid = new char[r][c];
		for (int i = 0; i < r; ++i) {
			grid[i] = read.nextLine().toCharArray();
		}
		
		int maxNumberOfCakesEaten = 0;
		
		for (int i = 0; i < r; ++i) {
			if (String.valueOf(grid[i]).contains("S")) {
				continue;
			}
			for (int j = 0; j < c; ++j) {
				if (grid[i][j] == '.') {
					maxNumberOfCakesEaten++;
					grid[i][j] = '-'; // mark cake as eaten
				}
			}
		}
		
		for (int j = 0; j < c; ++j) {
			boolean foundStrawberry = false;
			for (int i = 0; i < r; ++i) {
				if (grid[i][j] == 'S') {
					foundStrawberry = true;
					break;
				}
			}
			if (!foundStrawberry) {
				for (int i = 0; i < r; ++i) {
					if (grid[i][j] == '.') {
						maxNumberOfCakesEaten++;
						grid[i][j] = '-'; // mark cake as eaten
					}
				}
			}
		}
		
		System.out.println(maxNumberOfCakesEaten);
		
		// Close scanner
		read.close();
	}

}
