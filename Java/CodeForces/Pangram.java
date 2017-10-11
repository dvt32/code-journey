// http://codeforces.com/problemset/problem/520/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int lineLength = Integer.parseInt( read.nextLine() );
		String line = read.nextLine().toLowerCase();
		boolean isPangram = true;
		
		for (char c = 'a'; c <= 'z'; ++c) {
			if ( !line.contains(String.valueOf(c)) ) {
				isPangram = false;
				break;
			}
		}
		
		if (isPangram) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
}
