// http://codeforces.com/problemset/problem/831/B

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		String firstLayout = read.nextLine();
		String secondLayout = read.nextLine();
		String s = read.nextLine();
		
		Map<Character, Character> secondLayoutEquivalents = new HashMap<Character, Character>();
		for (int i = 0; i < 26; ++i) {
			secondLayoutEquivalents.put( firstLayout.charAt(i), secondLayout.charAt(i) );
		}
		
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (!secondLayoutEquivalents.containsKey(Character.toLowerCase(c))) {
				output.append(c);
			}
			else {
				if (Character.isUpperCase(c)) {
					output.append( 
						Character.toUpperCase( 
							secondLayoutEquivalents.get(
								Character.toLowerCase(c)	
							)
						)
					);
				}
				else {
					output.append( secondLayoutEquivalents.get(c) );
				}
			}
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}
}
