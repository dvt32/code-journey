// https://codeforces.com/problemset/problem/814/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int k = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		int[] b = new int[k];
		for (int i = 0; i < k; ++i) {
			b[i] = read.nextInt();
		}
		
		Arrays.sort(b);
		
		for (int i = 0, j = k-1; i < n; ++i) {
			if (a[i] == 0) {
				a[i] = b[j];
				j--;
			}
		}
		
		int[] a_sorted = a.clone();
		Arrays.sort(a_sorted);
		
		if (Arrays.equals(a, a_sorted)) {
			System.out.println("No");
		}
		else {
			System.out.println("Yes");
		}
		
		// Close scanner
		read.close();
	}
}
