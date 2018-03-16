// http://codeforces.com/problemset/problem/570/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int m = read.nextInt();
		
		int[] wins = new int[n];
		
		int[][] a = new int[m][n];
		for (int i = 0; i < m; ++i) {
			int maxVotes = 0;
			int winnerIndex = 0;
			for (int j = 0; j < n; ++j) {
				a[i][j] = read.nextInt();
				if (a[i][j] > maxVotes) {
					maxVotes = a[i][j];
					winnerIndex = j;
				}
			}
			wins[winnerIndex]++;
		}
		
		int maxWins = 0;
		int maxWinsIndex = 0;
		for (int i = 0; i < n; ++i) {
			if (wins[i] > maxWins) {
				maxWins = wins[i];
				maxWinsIndex = i;
			}
		}
		
		System.out.println(maxWinsIndex + 1); // candidates are numbered from 1 to 'n'
		
		// Close scanner
		read.close();
	}
	
}
