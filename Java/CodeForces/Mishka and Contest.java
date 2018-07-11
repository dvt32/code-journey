// http://codeforces.com/problemset/problem/999/A

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
		
		int maxNumberOfSolvedProblems = 0;
		
		int i = 0;
		while (i < n && a[i] <= k) {
			maxNumberOfSolvedProblems++;
			i++;
		}
		i--;
		
		int j = n-1;
		while (j >= 0 && j > i && a[j] <= k) {
			maxNumberOfSolvedProblems++;
			j--;
		}
		
		System.out.println(maxNumberOfSolvedProblems);
		
		// Close scanner
		read.close();
	}
}
