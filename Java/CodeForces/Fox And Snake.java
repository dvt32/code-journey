// http://codeforces.com/problemset/problem/510/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		boolean tailOnLeftSideOfTable = false;
		for (int i = 0; i < n; ++i) {
			if (i % 2 == 0) {
				for (int j = 0; j < m; ++j) {
					System.out.print("#");
				}
				System.out.println();
			}
			else {
				if (tailOnLeftSideOfTable) {
					System.out.print("#");
					for (int j = 1; j < m; ++j) {
						System.out.print(".");
					}
					System.out.println();
					tailOnLeftSideOfTable = false;
				}
				else {
					for (int j = 0; j < m-1; ++j) {
						System.out.print(".");
					}
					System.out.print("#");
					System.out.println();
					tailOnLeftSideOfTable = true;
				}
			}
		}
		
		// Close scanner
		read.close();
	}
	
}
