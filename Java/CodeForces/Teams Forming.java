// https://codeforces.com/problemset/problem/1092/B

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		Arrays.sort(a);
		
		int result = 0;
		for (int i = 0; i < n; i += 2) {
			result += Math.abs(a[i] - a[i+1]);
		}
		
		System.out.println(result);
		
		// Close scanner
		read.close();
	}

}
