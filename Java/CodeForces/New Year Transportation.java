// http://codeforces.com/problemset/problem/500/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int t = read.nextInt();
		
		int[] a = new int[n-1];
		for (int i = 0; i < n-1; ++i) {
			a[i] = read.nextInt();
			
		}
		
		boolean possibleToVisitCell = false;
		for (int i = 0; i < n-1; ) {
			i = a[i]+i; // teleport to cell via portal
			if (i == t-1) { // subtract 1, because indices start from 0
				possibleToVisitCell = true;
				break;
			}
		}
		
		if (possibleToVisitCell) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}

		// Close scanner
		read.close();
	}

}
