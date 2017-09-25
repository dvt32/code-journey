// http://codeforces.com/problemset/problem/96/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String firstLine = read.nextLine();
		String secondLine = read.nextLine();
		
		int compareResult = ( firstLine.compareToIgnoreCase(secondLine) );
		
		if (compareResult < 0) {
			System.out.println("-1");
		}
		else if (compareResult == 0) {
			System.out.println("0");
		}
		else {
			System.out.println("1");
		}
		
		// Close scanner
		read.close();
	}
	
}
