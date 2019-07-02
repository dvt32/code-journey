// https://codeforces.com/problemset/problem/25/B

import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt(read.nextLine());
		String number = read.nextLine();
		
		StringJoiner output = new StringJoiner("-");
		if (n % 2 == 0) {
			for (int i = 0; i < n; i += 2) {
				output.add( number.charAt(i) + "" + number.charAt(i+1) );
			}
		}
		else {
			for (int i = 0; i < n-3; i += 2) {
				output.add( number.charAt(i) + "" + number.charAt(i+1) );
			}
			output.add( number.substring(n-3) );
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}

}
