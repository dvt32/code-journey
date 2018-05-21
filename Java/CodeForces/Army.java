// http://codeforces.com/problemset/problem/38/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int[] d = new int[n-1];
		for (int i = 0; i < n-1; ++i) {
			d[i] = read.nextInt();
		}
		
		int a = read.nextInt();
		int b = read.nextInt();
		int numberOfYears = 0;
		for (int i = a-1; i < b-1; ++i) {
			numberOfYears += d[i];
		}
		
		System.out.println(numberOfYears);
		
		// Close scanner
		read.close();
	}
	
}
