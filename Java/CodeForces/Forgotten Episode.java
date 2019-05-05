// https://codeforces.com/problemset/problem/440/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		long totalSum = 0;
		for (int i = 1; i <= n; ++i) {
			totalSum += i;
		}
		
		long watchedSum = 0;
		for (int i = 0; i < n-1; ++i) {
			watchedSum += read.nextInt();
		}
		
		System.out.println(totalSum - watchedSum);
		
		// Close scanner
		read.close();
	}

}
