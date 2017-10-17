// http://codeforces.com/problemset/problem/266/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int numberOfStones = Integer.parseInt( read.nextLine() );
		String line = read.nextLine();
		
		int minNumberOfStonesToTake = 0;
		for (int i = 1; i < numberOfStones; ++i) {
			if ( line.charAt(i) == line.charAt(i-1) ) {
				minNumberOfStonesToTake++;
			}
		}
		
		System.out.println( minNumberOfStonesToTake );
		
		// Close scanner
		read.close();
	}
	
}
