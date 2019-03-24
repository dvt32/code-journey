// https://codeforces.com/problemset/problem/808/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		if (n < 10) {
			System.out.println("1");
		}
		else {
			String numberAsString = String.valueOf(n);
			int numberOfDigits = numberAsString.length();
			int firstDigit = Character.getNumericValue(numberAsString.charAt(0));
			int nextLuckyYear = (firstDigit + 1) * ((int) Math.pow(10, numberOfDigits-1));
			System.out.println(nextLuckyYear - n);
		}

		// Close scanner
		read.close();
	}

}
