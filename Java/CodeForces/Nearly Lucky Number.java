// http://codeforces.com/problemset/problem/110/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String line = read.nextLine();
		int luckyDigitCount = 0;
		
		for (int i = 0; i < line.length(); ++i) {
			if (line.charAt(i) == '4' || line.charAt(i) == '7') {
				luckyDigitCount++;
			}
		}
		
		if (luckyDigitCount == 4 || luckyDigitCount == 7) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
