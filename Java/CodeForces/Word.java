// http://codeforces.com/problemset/problem/59/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String line = read.nextLine();
		
		int lowerCaseCount = 0;
		int upperCaseCount = 0;
		for (int i = 0; i < line.length(); ++i) {
			if ( Character.isLowerCase(line.charAt(i)) ) {
				lowerCaseCount++;
			}
			else {
				upperCaseCount++;
			}
		}
		
		if (lowerCaseCount < upperCaseCount) {
			System.out.println( line.toUpperCase() );
		}
		else {
			System.out.println( line.toLowerCase() );
		}
		
		// Close scanner
		read.close();
	}
}
