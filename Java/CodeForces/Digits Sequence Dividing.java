// https://codeforces.com/problemset/problem/1107/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int q = Integer.parseInt( read.nextLine() );
		for (int i = 0; i < q; ++i) {
			int n = Integer.parseInt( read.nextLine() );
			String s = read.nextLine();
			if (n == 2 && s.charAt(0) >= s.charAt(1)) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
				System.out.println("2");
				System.out.println(s.charAt(0) + " " + s.substring(1));
			}
		}
		
		// Close scanner
		read.close();
	}

}
