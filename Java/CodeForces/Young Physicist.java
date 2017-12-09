// http://codeforces.com/problemset/problem/69/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[][] coordinates = new int[n][3];
		for (int i = 0; i < n; ++i) {
			coordinates[i][0] = read.nextInt(); // 'x'
			coordinates[i][1] = read.nextInt(); // 'y'
			coordinates[i][2] = read.nextInt(); // 'z'
		}
		
		boolean isInEquilibrium = true;
		for (int j = 0; j < 3; ++j) {
			int sum = 0;
			for (int i = 0; i < n; ++i) {
				sum += coordinates[i][j];
			}
			if (sum != 0) {
				isInEquilibrium = false;
				break;
			}
		}
		
		if (isInEquilibrium) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
