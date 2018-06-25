// http://codeforces.com/problemset/problem/262/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		int validNumberCount = 0;
		for (int i = 0; i < n; ++i) {
			int number = read.nextInt();
			String numberStr = String.valueOf(number);
			int numberOfLuckyDigits = 0;
			for (int j = 0; j < numberStr.length(); ++j) {
				char c = numberStr.charAt(j);
				if (c == '4' || c == '7') {
					numberOfLuckyDigits++;
				}
			}
			if (numberOfLuckyDigits <= k) {
				validNumberCount++;
			}
		}
		
		System.out.println(validNumberCount);
		
		// Close scanner
		read.close();
	}
}
