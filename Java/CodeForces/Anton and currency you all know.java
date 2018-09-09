// http://codeforces.com/problemset/problem/508/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		char[] n = read.nextLine().toCharArray();
		
		// Close scanner
		read.close();
		
		int lastDigit = Character.getNumericValue(n[n.length-1]);
		
		for (int i = 0; i < n.length; ++i) {
			char digit = n[i];
			int digitNumericValue = Character.getNumericValue(digit);
			if (digitNumericValue % 2 == 0 && digitNumericValue < lastDigit) {
				char temp = n[n.length-1];
				n[n.length-1] = digit;
				n[i] = temp;
				System.out.println(n);
				return;
			}
		}
		
		for (int i = n.length-2; i >= 0; --i) {
			char digit = n[i];
			int digitNumericValue = Character.getNumericValue(digit);
			if (digitNumericValue % 2 == 0 && digitNumericValue > lastDigit) {
				char temp = n[n.length-1];
				n[n.length-1] = digit;
				n[i] = temp;
				System.out.println(n);
				return;
			}
		}	
		
		System.out.println("-1");
	}

}
