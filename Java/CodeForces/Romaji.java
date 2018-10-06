// http://codeforces.com/problemset/problem/1008/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		String s = read.nextLine();
		
		final String VOWELS = "aouie";
		
		boolean isBerlanese = true;
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			boolean isConsonant = !( VOWELS.contains(String.valueOf(c)) );
			if (isConsonant) {
				if (c != 'n') {
					if ( i+1 == s.length() ||
						 !( VOWELS.contains(String.valueOf(s.charAt(i+1))) )
					   ) 
					{
						isBerlanese = false;
						break;
					}
				}
			}
		}
		
		if (isBerlanese) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}

		// Close scanner
		read.close();
	}

}
