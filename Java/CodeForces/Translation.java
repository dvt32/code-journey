// http://codeforces.com/problemset/problem/41/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		String t = read.nextLine();
		
		if ( new StringBuilder(s).reverse().toString().equals(t) ) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
