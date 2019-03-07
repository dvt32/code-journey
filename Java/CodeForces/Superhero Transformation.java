// https://codeforces.com/problemset/problem/1111/A

import java.util.Scanner;

public class Solution {
	
	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; 
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		String t = read.nextLine();
		
		if (s.length() == t.length()) {
			boolean canBeTransformed = true;
			for (int i = 0; i < s.length(); ++i) {
				if ( (isVowel(s.charAt(i)) && !isVowel(t.charAt(i))) ||
					 (!isVowel(s.charAt(i)) && isVowel(t.charAt(i)))
				   ) 
				{
					canBeTransformed = false;
					break;
				}
			}
			System.out.println( canBeTransformed ? "Yes" : "No" );
		}
		else {
			System.out.println("No");
		}
		
		// Close scanner
		read.close();
	}

}
