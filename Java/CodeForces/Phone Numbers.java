// https://codeforces.com/problemset/problem/1060/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		read.nextLine();
		
		String s = read.nextLine();
		
		int maxPhoneNumberCount = n / 11;
		int eightCount = 0;
		
		for (int i = 0; i < n; ++i) {
			if (s.charAt(i) == '8') {
				eightCount++;
			}
		}
		
		if (eightCount < maxPhoneNumberCount) {
			maxPhoneNumberCount = eightCount;
		}
		
		System.out.println(maxPhoneNumberCount);
	
		// Close scanner
		read.close();
	}

}
