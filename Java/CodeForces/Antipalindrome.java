// https://codeforces.com/problemset/problem/724/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		
		boolean isPalindrome = s.equals(new StringBuilder(s).reverse().toString());
		if (isPalindrome) {
			while (s.length() != 1) {
				s = s.substring(0, s.length()-1);
				isPalindrome = s.equals(new StringBuilder(s).reverse().toString());
				if (!isPalindrome) {
					System.out.println(s.length());
					break;
				}
			}
			if (s.length() == 1) {
				System.out.println("0");
			}
		}
		else {
			System.out.println( s.length() );
		}

		// Close scanner
		read.close();
	}

}
