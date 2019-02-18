// https://codeforces.com/problemset/problem/572/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int nA = read.nextInt();
		int nB = read.nextInt();
		int k = read.nextInt();
		int m = read.nextInt();
		
		int[] a = new int[nA];
		for (int i = 0; i < nA; ++i) {
			a[i] = read.nextInt();
		}
		
		int[] b = new int[nB];
		for (int i = 0; i < nB; ++i) {
			b[i] = read.nextInt();
		}
		
		boolean possible = true;
		for (int i = nB-1, j = 0; 
			 j < m; 
			 --i, ++j) 
		{
			if (b[i] <= a[k-1]) {
				possible = false;
				break;
			}
		}
		
		if (possible) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
