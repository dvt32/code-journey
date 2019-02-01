// https://codeforces.com/problemset/problem/294/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		int m = read.nextInt();
		for (int i = 0; i < m; ++i) {
			int x = read.nextInt();
			int y = read.nextInt();
			
			int numberOfBirdsToTheLeft = y-1;	
			int numberOfBirdsToTheRight = a[x-1] - y; // x-1, because array indices start from 0
			
			if (x-2 < n && x-2 >= 0) {
				a[x-2] += numberOfBirdsToTheLeft;
			}
			if (x < n && x >= 0) {
				a[x] += numberOfBirdsToTheRight;
			}
			
			a[x-1] = 0; // one bird is dead, the ones to the left and the right fly away or move to adjacent wires
		}
		
		for (int i = 0; i < n; ++i) {
			System.out.println(a[i]);
		}
		
		// Close scanner
		read.close();
	}

}
