// http://codeforces.com/problemset/problem/385/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int c = read.nextInt();
		
		int[] x = new int[n];
		for (int i = 0; i < n; ++i) {
			x[i] = read.nextInt();
		}
		
		int maxKilos = 0;
		for (int i = 0; i < n-1; ++i) {
			int kilos = (x[i] - x[i+1] - c);
			if (kilos > maxKilos) {
				maxKilos = kilos;
			}
		}
		
		System.out.println(maxKilos);

		// Close scanner
		read.close();
	}

}
