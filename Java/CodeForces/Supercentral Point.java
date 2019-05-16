// https://codeforces.com/problemset/problem/165/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; ++i) {
			x[i] = read.nextInt();
			y[i] = read.nextInt();
		}
		
		int numberOfSupercentralPoints = 0;
		for (int i = 0; i < n; ++i) {
			int currentPointX = x[i];
			int currentPointY = y[i];
			
			boolean rightNeighborFound = false;
			boolean leftNeighborFound = false;
			boolean lowerNeighborFound = false;
			boolean upperNeighborFound = false;
			
			for (int j = 0; j < n; ++j) {
				if (x[j] > currentPointX && y[j] == currentPointY) {
					rightNeighborFound = true;
				}
				if (x[j] < currentPointX && y[j] == currentPointY) {
					leftNeighborFound = true;
				}
				if (x[j] == currentPointX && y[j] < currentPointY) {
					lowerNeighborFound = true;
				}
				if (x[j] == currentPointX && y[j] > currentPointY) {
					upperNeighborFound = true;
				}
			}
			
			boolean isSupercentralPoint = 
				(rightNeighborFound && leftNeighborFound && lowerNeighborFound && upperNeighborFound);
			
			if (isSupercentralPoint) {
				numberOfSupercentralPoints++;
			}
		}
		
		System.out.println( numberOfSupercentralPoints );
		
		// Close scanner
		read.close();
	}

}
