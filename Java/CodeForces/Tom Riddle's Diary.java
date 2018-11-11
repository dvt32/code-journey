// http://codeforces.com/problemset/problem/855/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		read.nextLine();
		
		Set<String> names = new HashSet<String>();
		for (int i = 0; i < n; ++i) {
			String s = read.nextLine();
			if (names.contains(s)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
				names.add(s);
			}
		}
		
		// Close scanner
		read.close();
	}

}
