// https://codeforces.com/problemset/problem/169/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int a = read.nextInt();
		int b = read.nextInt();
		
		int[] h = new int[n];
		for (int i = 0; i < n; ++i) {
			h[i] = read.nextInt();
		}
		
		Arrays.sort(h);

		System.out.println(h[b] - h[b-1]);
		
		// Close scanner
		read.close();
	}

}
