// http://codeforces.com/problemset/problem/236/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String line = read.nextLine();
		
		Set<Character> distinctCharacters = new HashSet<Character>();
		for (int i = 0; i < line.length(); ++i) {
			distinctCharacters.add( line.charAt(i) );
		}
		
		boolean isFemale = (distinctCharacters.size() % 2 == 0);
		if (isFemale) {
			System.out.println("CHAT WITH HER!");
		}
		else {
			System.out.println("IGNORE HIM!");
		}
		
		// Close scanner
		read.close();
	}
	
}
