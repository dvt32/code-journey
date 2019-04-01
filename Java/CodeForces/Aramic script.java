// https://codeforces.com/problemset/problem/975/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		
		String[] words = read.nextLine().split(" ");
		
		Set<String> uniqueRoots = new HashSet<>();
		for (int i = 0; i < n; ++i) {
			char[] s = words[i].toCharArray();
			SortedSet<Character> uniqueChars = new TreeSet<>();
			for (Character c : s) {
				uniqueChars.add(c);
			}
			uniqueRoots.add(uniqueChars.toString());
		}
		
		System.out.println(uniqueRoots.size());

		// Close scanner
		read.close();
	}

}
