// https://codeforces.com/problemset/problem/672/B

// https://codeforces.com/blog/entry/44821

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		String s = read.nextLine();
		
		Set<Character> distinctCharacters = new HashSet<>();
		for (int i = 0; i < n; ++i) {
			char c = s.charAt(i);
			distinctCharacters.add(c);
		}
		
		if (n > 26) {
			System.out.println("-1");
		}
		else if (distinctCharacters.size() == n) {
			System.out.println("0");
		}
		else {
			int k = distinctCharacters.size();
			System.out.println(n - k);
		}
		
		// Close scanner
		read.close();
	}

}
