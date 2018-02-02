// http://codeforces.com/problemset/problem/448/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		// a1, a2, a3
		int cupCount = 0;
		for (int i = 0; i < 3; ++i) {
			cupCount += read.nextInt();
		}
		int numberOfShelvesNeededForCups = cupCount / 5;
		if (cupCount % 5 != 0) { 
			numberOfShelvesNeededForCups++;
		}
		
		// b1, b2, b3
		int medalCount = 0;
		for (int i = 0; i < 3; ++i) {
			medalCount += read.nextInt();
		}
		int numberOfShelvesNeededForMedals = medalCount / 10;
		if (medalCount % 10 != 0) { 
			numberOfShelvesNeededForMedals++;
		}
		
		// number of shelves available
		int n = read.nextInt();
		
		// print end result
		if (n >= (numberOfShelvesNeededForCups + numberOfShelvesNeededForMedals)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
