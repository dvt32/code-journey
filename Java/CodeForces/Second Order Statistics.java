// https://codeforces.com/problemset/problem/22/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		int[] a = new int[n];
		
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			if (a[i] < min) {
				secondMin = min;
				min = a[i];
			}
			else if (a[i] < secondMin && a[i] != min) {
				secondMin = a[i];
			}
		}
		
		if (secondMin == Integer.MAX_VALUE) {
			System.out.println("NO");
		}
		else {
			System.out.println(secondMin);
		}

		// Close scanner
		read.close();
	}

}
