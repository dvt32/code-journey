// http://codeforces.com/problemset/problem/258/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String a = read.nextLine();
		
		if (a.contains("0")) {
			for (int i = 0; i < a.length(); ++i) {
				if (a.charAt(i) == '0') {
					System.out.println(
						a.substring(0, i) + 
						( (i+1) < a.length() ? a.substring(i+1) : "") 
					);
				}
			}
		}
		else {
			System.out.println(a.substring(1));
		}
		
		// Close scanner
		read.close();
	}

}
