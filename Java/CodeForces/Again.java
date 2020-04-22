// https://codeforces.com/problemset/problem/1331/D

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String input = read.nextLine();
		
		int inputLength = input.length();
		int lastDigit = Character.getNumericValue( input.charAt(inputLength-1) );
		
		System.out.println( lastDigit % 2 == 0 ? "0" : "1" );
		
		// Close scanner
		read.close();
	}

}
