// https://codeforces.com/problemset/problem/873/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		int x = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		for (int i = n-1; i >= 0 && k > 0; --i) {
			a[i] = x;
			k--;
		}
		
		int sum = Arrays.stream(a).sum();
		System.out.println(sum);
		
		// Close scanner
		read.close();
	}

}
