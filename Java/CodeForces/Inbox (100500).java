// https://codeforces.com/problemset/problem/465/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] letterStates = new int[n];
		int unreadLetterCount = 0;
		for (int i = 0; i < n; ++i) {
			letterStates[i] = read.nextInt();
			if (letterStates[i] == 1) {
				unreadLetterCount++;
			}
		}
		
		int minOperationCount = 0;
		for (int i = 0; i < n; ++i) {
			if (letterStates[i] == 1) {
				while (i < n && letterStates[i] == 1) {
					minOperationCount++;
					unreadLetterCount--;
					i++;
				}
				if (i < n && unreadLetterCount > 0) {
					minOperationCount++;
				}
			}
		}
		
		System.out.println(minOperationCount);
		
		// Close scanner
		read.close();
	}

}
