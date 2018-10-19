// http://codeforces.com/problemset/problem/879/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] s = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < n; ++i) {
			s[i] = read.nextInt();
			d[i] = read.nextInt();
		}
		
		int minDay = s[0];
		for (int i = 1; i < n; ++i) {
			int j = 0;
			while (s[i] + j*d[i] <= minDay) {
				j++;
			}
			minDay = s[i] + j*d[i];
		}
		
		System.out.println(minDay);
		
		// Close scanner
		read.close();
	}

}
