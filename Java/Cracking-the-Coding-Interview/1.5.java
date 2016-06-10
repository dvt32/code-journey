/*
 * 1.5 Write a method to replace all spaces in a string with ‘%20’.
 */

import java.util.Scanner;

public class Solution {
	
	// With new String object
	public static String replaceAllSpaces(String inputString) {
		String outputString = "";
		for (int i = 0; i < inputString.length(); ++i) {
			if (inputString.charAt(i) == ' ') {
				outputString += "%20";
			}
			else {
				outputString += inputString.charAt(i);
			}
		}
		return outputString;
	}
	
	// Without new String object
	public static String replaceAllSpaces_alt(String inputString) {
		for (int i = 0; i < inputString.length(); ++i) {
			if (inputString.charAt(i) == ' ') {
				inputString = inputString.replaceAll(" ", "%20");
			}
		}
		return inputString;
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String input = read.nextLine();
		input = replaceAllSpaces_alt(input);
		
		System.out.println(input);
		
		
		// Close scanner
		read.close();
	}
}
