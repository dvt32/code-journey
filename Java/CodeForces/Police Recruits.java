// http://codeforces.com/problemset/problem/427/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int numberOfAvailableOfficers = 0;
		int numberOfUntreatedCrimes = 0;
		
		for (int i = 0; i < n; ++i) {
			int number = read.nextInt();
			if (number > 0) {
				numberOfAvailableOfficers += number;
			}
			else {
				if (numberOfAvailableOfficers > 0) {
					numberOfAvailableOfficers--;
				}
				else {
					numberOfUntreatedCrimes++;
				}
			}
		}
		
		System.out.println( numberOfUntreatedCrimes );
		
		// Close scanner
		read.close();
	}
	
}
