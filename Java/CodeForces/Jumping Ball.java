// https://codeforces.com/problemset/problem/725/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		String bumpers = read.nextLine();
		
		int numberOfValidStartingPositions = 0;
		for (int i = 0; i < n && bumpers.charAt(i) == '<'; ++i) {
			numberOfValidStartingPositions++;
		}
		for (int i = n-1; i >= 0 && bumpers.charAt(i) == '>'; --i) {
			numberOfValidStartingPositions++;
		}
		
		System.out.println(numberOfValidStartingPositions);

		// Close scanner
		read.close();
	}

}
