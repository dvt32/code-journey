// http://codeforces.com/problemset/problem/551/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = read.nextInt();
		}
		
		for (int i = 0; i < n; ++i) {
			int position = 1;
			for (int j = 0; j < n; ++j) {
				if (arr[j] > arr[i]) {
					position++;
				}
			}
			System.out.print(position + " ");
		}
		
		System.out.println();

		// Close scanner
		read.close();
	}
	
}
