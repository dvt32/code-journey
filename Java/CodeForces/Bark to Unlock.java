// https://codeforces.com/problemset/problem/868/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String password = read.nextLine();
		
		int n = read.nextInt();
		
		read.nextLine();
		
		boolean existsWordEqualToPassword = false;
		boolean existsWordWithFirstLetterEqualToSecondLetterOfPassword = false;
		boolean existsWordWithSecondLetterEqualToFirstLetterOfPassword = false;
		
		for (int i = 0; i < n; ++i) {
			String word = read.nextLine();
			if (word.equals(password)) {
				existsWordEqualToPassword = true;
			}
			if (word.charAt(0) == password.charAt(1)) {
				existsWordWithFirstLetterEqualToSecondLetterOfPassword = true;
			}
			if (word.charAt(1) == password.charAt(0)) {
				existsWordWithSecondLetterEqualToFirstLetterOfPassword = true;
			}
		}
		
		if (existsWordEqualToPassword) {
			System.out.println("YES");
		}
		else if (existsWordWithFirstLetterEqualToSecondLetterOfPassword && existsWordWithSecondLetterEqualToFirstLetterOfPassword) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
