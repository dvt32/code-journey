// http://codeforces.com/problemset/problem/344/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		int groupCount = 0;

		String previousMagnetPair = "";
		for (int i = 0; i < n; ++i) {
			String magnetPair = read.nextLine();
			if ( !magnetPair.equals(previousMagnetPair) ) {
				groupCount++;
			}
			previousMagnetPair = magnetPair;
		}
		
		System.out.println( groupCount );
		
		// Close scanner
		read.close();
	}
	
}
