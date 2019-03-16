// https://codeforces.com/problemset/problem/844/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		int k = read.nextInt();
		
		if (k > s.length()) {
			System.out.println("impossible");
		}
		else {
			Set<Character> uniqueChars = new HashSet<>();
			for (int i = 0; i < s.length(); ++i) {
				uniqueChars.add(s.charAt(i));
			}
			System.out.println( Math.max(0, k - uniqueChars.size()) );
		}
		
		// Close scanner
		read.close();
	}

}
