// http://codeforces.com/problemset/problem/404/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		read.nextLine(); // clear buffer
		
		// Enter input
		String[] lines = new String[n];
		for (int i = 0; i < n; ++i) {
			lines[i] = read.nextLine();
		}
		
		read.close(); // close scanner
		
		boolean[][] letterVisited = new boolean[n][n];
		char diagonalLetter = lines[0].charAt(0);
		
		// Check if left diagonal is valid
		for (int i = 0, j = 0; 
			 i < n && j < n; 
			 ++i, ++j) 
		{
			letterVisited[i][j] = true;
			char c = lines[i].charAt(j);
			if (c != diagonalLetter) {
				System.out.println("NO");
				return;
			}
		}

		// Check if right diagonal is valid
		for (int i = 0, j = n-1; 
			 i < n && j >= 0; 
			 ++i, --j) 
		{
			letterVisited[i][j] = true;
			char c = lines[i].charAt(j);
			if (c != diagonalLetter) {
				System.out.println("NO");
				return;
			}
		}
		
		// Check if all other letters are one and the same
		char letter = lines[0].charAt(1);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				char c = lines[i].charAt(j);
				if (!letterVisited[i][j]) {
					if (c != letter || c == diagonalLetter) {
						System.out.println("NO");
						return;
					}
				}
			}
		}
		
		System.out.println("YES");
	}
	
}
