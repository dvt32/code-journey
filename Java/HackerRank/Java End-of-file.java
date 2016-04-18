// https://www.hackerrank.com/challenges/java-end-of-file

import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner read = new Scanner(System.in);
		
		int lineNumber = 1;
		while (read.hasNext()) {
			String line = read.nextLine();
			System.out.println(lineNumber + " " + line);
			lineNumber++;
		}
		
		// Close scanner
		read.close();
	}
}
