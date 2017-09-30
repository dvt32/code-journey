// http://codeforces.com/problemset/problem/131/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String line = read.nextLine();
		
		boolean isWrittenWithCapsLockByAccident = isWrittenWithCapsLockByAccident(line);
		if (isWrittenWithCapsLockByAccident) {
			StringBuilder lineWithSwappedCase = new StringBuilder();
			for (int i = 0; i < line.length(); ++i) {
				char currentChar = line.charAt(i);
				if ( Character.isUpperCase(currentChar) ) {
					lineWithSwappedCase.append( Character.toLowerCase(currentChar) );
				}
				else {
					lineWithSwappedCase.append( Character.toUpperCase(currentChar) );
				}
			}
			System.out.println( lineWithSwappedCase );
		}
		else {
			System.out.println( line );
		}
		
		// Close scanner
		read.close();
	}
	
	public static boolean isWrittenWithCapsLockByAccident(String line) {
		if (line.length() == 1) {
			return true;
		}
		
		boolean isAllCaps = line.equals(line.toUpperCase());
		boolean onlyFirstLetterIsLowerCase =
			Character.isLowerCase( line.charAt(0) ) &&
			line.substring(1).equals( line.substring(1).toUpperCase() );
		
		return ( isAllCaps || onlyFirstLetterIsLowerCase );
	}
	
}
