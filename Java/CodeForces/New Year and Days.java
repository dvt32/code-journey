// http://codeforces.com/problemset/problem/611/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String line = read.nextLine();
		
		int number = Integer.parseInt( line.substring(0, line.indexOf(" ")) );
		int numberOfSavedCandies = 0;
		if (line.endsWith("of week")) {
			numberOfSavedCandies = (number == 5 || number == 6) ? 53 : 52;
		}
		else { // line.endsWith("of month") == true
			if (number > 29) { // 2016 is leap year
				numberOfSavedCandies = (number == 31) ? 7 : 11;
			}
			else {
				numberOfSavedCandies = 12;
			}
		}
		
		System.out.println(numberOfSavedCandies);
		
		// Close scanner
		read.close();
	}
}
