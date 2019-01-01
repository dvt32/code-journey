// https://codeforces.com/problemset/problem/1095/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		read.nextLine();
		String t = read.nextLine();
		
		StringBuilder s = new StringBuilder();
		int step = 0;
		for (int i = 0; i < n; i += step) {
			s.append( t.charAt(i) );
			step++;
		}
		
		System.out.println(s);
		
		// Close scanner
		read.close();
	}

}
