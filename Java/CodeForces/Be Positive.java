// https://codeforces.com/problemset/problem/1130/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		int[] a = new int[n];
		int positiveNumberCount = 0;
		int negativeNumberCount = 0;
		int zeroCount = 0;
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			if (a[i] > 0) { positiveNumberCount++; }
			else if (a[i] < 0) { negativeNumberCount++; }
			else { zeroCount++; }
		}
		
		int minNumberOfPositiveNumbersNeededAfterDivision = (n % 2 == 0) ? n/2: (n/2)+1;
		int d = 0;
		if (positiveNumberCount >= minNumberOfPositiveNumbersNeededAfterDivision) {
			d = 1;
		}
		else if (negativeNumberCount >= minNumberOfPositiveNumbersNeededAfterDivision) {
			d = -1;
		}

		System.out.println(d);
		
		// Close scanner
		read.close();
	}

}
