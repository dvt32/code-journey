// http://codeforces.com/problemset/problem/573/A
// can be optimized a little

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int numberOfLeftSidePoints = 0;
		int numberOfRightSidePoints = 0;
		
		int n = read.nextInt();
		for (int i = 0; i < n; ++i) {
			int x = read.nextInt();
			int y = read.nextInt();
			if (x < 0) {
				numberOfLeftSidePoints++;
			}
			else {
				numberOfRightSidePoints++;
			}
		}
		
		if (numberOfLeftSidePoints == 0 || 
			numberOfRightSidePoints == 0 ||
			numberOfLeftSidePoints == 1 || 
			numberOfRightSidePoints == 1) 
		{
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
		// Close scanner
		read.close();
	}
}
