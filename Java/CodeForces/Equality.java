// https://codeforces.com/problemset/problem/1038/A

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		read.nextLine();
		
		String s = read.nextLine();
		
		Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
		for (char c = 'A'; c < (char) 'A'+k; ++c) {
			frequencies.put(c, 0);
		}
		
		for (int i = 0; i < n; ++i) {
			char c = s.charAt(i);
			frequencies.put(c, frequencies.get(c)+1);
		}

		System.out.println( Collections.min(frequencies.values()) * k );
		
		// Close scanner
		read.close();
	}

}
