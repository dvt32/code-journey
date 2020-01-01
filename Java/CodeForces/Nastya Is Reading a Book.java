// https://codeforces.com/problemset/problem/1136/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] l = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; ++i) {
			l[i] = read.nextInt();
			r[i] = read.nextInt();
		}
		
		int k = read.nextInt();
		
		int numberOfUnfinishedChapters = 0;
		for (int i = 0; i < n; ++i) {
			if (k <= r[i]) {
				numberOfUnfinishedChapters++;
			}
		}
		
		System.out.println(numberOfUnfinishedChapters);
	
		// Close scanner
		read.close();
	}

}
