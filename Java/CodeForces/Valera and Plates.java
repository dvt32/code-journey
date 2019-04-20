// https://codeforces.com/problemset/problem/369/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt(); 
		int m = read.nextInt(); // clean bowls
		int k = read.nextInt(); // clean plates
		
		int minNumberOfCleans = 0;
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			if (a[i] == 1) {
				if (m > 0) {
					m--;
				}
				else {
					minNumberOfCleans++;
				}
			}
			else {
				if (k > 0) {
					k--;
				}
				else if (m > 0) {
					m--;
				}
				else {
					minNumberOfCleans++;
				}
			}
		}
		
		System.out.println(minNumberOfCleans);
		
		// Close scanner
		read.close();
	}

}
