// http://codeforces.com/problemset/problem/892/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		long volumeOfColaInAllCans = 0;
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			volumeOfColaInAllCans += a;
		}
		
		int[] b = new int[n];
		for (int i = 0; i < n; ++i) {
			b[i] = read.nextInt();
		}
		
		Arrays.sort(b);
		
		long biggestAndSecondBiggestCanCapacity = b[n-1] + b[n-2];
		if (biggestAndSecondBiggestCanCapacity >= volumeOfColaInAllCans) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
