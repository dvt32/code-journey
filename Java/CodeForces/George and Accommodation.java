// http://codeforces.com/problemset/problem/467/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		int validRoomCount = 0;
		
		for (int i = 0; i < n; ++i) {
			String[] line = read.nextLine().split(" ");
			int p = Integer.parseInt( line[0] );
			int q = Integer.parseInt( line[1] );
			if (q-p >= 2) {
				validRoomCount++;
			}
		}
		
		System.out.println( validRoomCount );
		
		// Close scanner
		read.close();
	}
	
}
