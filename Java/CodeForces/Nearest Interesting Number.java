// https://codeforces.com/problemset/problem/1183/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt();
		
		int n = a-1;
		int sumOfDigits;
		
		do {
			n++;
			sumOfDigits = 0;
			int currentNumber = n;
			while (currentNumber > 0) {
				sumOfDigits += currentNumber % 10;
				currentNumber /= 10;
			}
		}
		while (sumOfDigits % 4 != 0);
		
		System.out.println(n);
		
		// Close scanner
		read.close();
	}

}
