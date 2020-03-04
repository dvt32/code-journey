// https://codeforces.com/problemset/problem/1296/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int t = read.nextInt();
		
		for (int testCaseNumber = 1; testCaseNumber <= t; ++testCaseNumber) {
			int n = read.nextInt();
			
			int[] a = new int[n];
			int sum = 0;
			for (int i = 0; i < n; ++i) {
				a[i] = read.nextInt();
				sum += a[i];
			}
			
			if (sum % 2 == 1) {
				System.out.println("YES");
			}
			else {
				boolean containsEvenNumber = false;
				boolean containsOddNumber = false;
				
				for (int i = 0; i < n; ++i) {
					if (a[i] % 2 == 0) {
						containsEvenNumber = true;
						break;
					}
				}
				for (int i = 0; i < n; ++i) {
					if (a[i] % 2 == 1) {
						containsOddNumber = true;
						break;
					}
				}
				
				if (containsEvenNumber && containsOddNumber) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
		
		// Close scanner
		read.close();
	}

}
