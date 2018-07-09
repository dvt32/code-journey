// http://codeforces.com/problemset/problem/265/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		String s = read.nextLine();
		String t = read.nextLine();
		
		int position = 1;
		for (int i = 0; i < t.length(); ++i) {
			if (s.charAt(position-1) == t.charAt(i)) {
				position++;
			}
		}
		
		System.out.println(position);
		
		// Close scanner
		read.close();
	}
}
