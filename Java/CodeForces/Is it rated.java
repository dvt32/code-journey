// https://codeforces.com/problemset/problem/807/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] b = new int[n];
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			b[i] = read.nextInt();
			if (a != b[i]) {
				read.close();
				System.out.println("rated");
				return;
			}
		}
		
		int[] b_copy = b.clone();
		Arrays.sort(b_copy);
		for (int i = 0, j = n-1; i < n; ++i, --j) {
			if (b[i] != b_copy[j]) {
				read.close();
				System.out.println("unrated");
				return;
			}
		}
		
		System.out.println("maybe");
		
		// Close scanner
		read.close();
	}

}
