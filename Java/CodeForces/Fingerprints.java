// http://codeforces.com/problemset/problem/994/A

import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		read.nextLine();
		
		String x = read.nextLine();
		String y = read.nextLine();
		
		StringJoiner output = new StringJoiner(" ");
		for (int i = 0; i < n*2; i += 2) { // every 2nd character, because of the whitespaces between digits
			String currentCharAsString = String.valueOf(x.charAt(i));
			if ( y.contains(currentCharAsString) ) {
				output.add(currentCharAsString);
			}
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}

}
