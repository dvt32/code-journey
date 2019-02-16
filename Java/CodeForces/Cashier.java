// https://codeforces.com/problemset/problem/1059/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int L = read.nextInt();
		int a = read.nextInt();

		int[] t = new int[n];
		int[] l = new int[n];
		for (int i = 0; i < n; ++i) {
			t[i] = read.nextInt();
			l[i] = read.nextInt();
		}
		
		int breakCount = 0;
		int currentTime  =0;
		for (int i = 0; i < n; ++i) {
			breakCount += (t[i] - currentTime) / a;
			currentTime = t[i] + l[i];
		}

		breakCount += (L - currentTime) / a;
		
		System.out.println(breakCount);
		
		// Close scanner
		read.close();
	}

}
