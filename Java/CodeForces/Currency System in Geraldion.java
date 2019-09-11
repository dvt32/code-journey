// https://codeforces.com/problemset/problem/560/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		boolean noUnfortunateSum = false;
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			if (a[i] == 1) {
				noUnfortunateSum = true;
				break;
			}
		}
		
		System.out.println( noUnfortunateSum ? "-1" : "1" );
	
		// Close scanner
		read.close();
	}

}
