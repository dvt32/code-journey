// https://codeforces.com/problemset/problem/411/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String password = read.nextLine();
		
		boolean isValidPassword = false;
		if (password.length() >= 5) {
			boolean hasUpperCaseChar = false;
			boolean hasLowerCaseChar = false;
			boolean hasDigit = false;
			
			for (int i = 0; i < password.length(); ++i) {
				char c = password.charAt(i);
				if (Character.isUpperCase(c)) {
					hasUpperCaseChar = true;
				}
				else if (Character.isLowerCase(c)) {
					hasLowerCaseChar = true;
				}
				else if (Character.isDigit(c)) {
					hasDigit = true;
				}
				if (hasUpperCaseChar && hasLowerCaseChar && hasDigit) {
					isValidPassword = true;
					break;
				}
			}
		}
		
		if (isValidPassword) {
			System.out.println("Correct");
		}
		else {
			System.out.println("Too weak");
		}
		
		// Close scanner
		read.close();
	}

}
