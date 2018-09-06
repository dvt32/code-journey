// http://codeforces.com/problemset/problem/719/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		// Close scanner
		read.close();
		
		int lastElement = a[n-1];
		
		if (lastElement == 15) {
			System.out.println("DOWN");
			return;
		}
		else if (lastElement == 0) {
			System.out.println("UP");
		}
		else if (n == 1) {
			System.out.println("-1");
		}
		else if (a[n-2] < lastElement) {
			System.out.println("UP");
		}
		else {
			System.out.println("DOWN");
		}
	}

}
