// http://codeforces.com/problemset/problem/711/A

import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		read.nextLine(); // clear buffer
		
		StringBuilder oldSeatConfiguration = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			oldSeatConfiguration.append( read.nextLine() + System.getProperty("line.separator"));
		}
		String newSeatConfiguration = oldSeatConfiguration.toString().replaceFirst(Pattern.quote("OO"), "++");
		
		if ( oldSeatConfiguration.toString().equals(newSeatConfiguration) ) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
			System.out.println(newSeatConfiguration);
		}
		
		// Close scanner
		read.close();
	}
	
}
