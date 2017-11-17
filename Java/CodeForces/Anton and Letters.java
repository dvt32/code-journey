// http://codeforces.com/problemset/problem/443/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String input = read.nextLine();
		input = input.substring(1, input.length()-1);
		
		if (input.length() == 0) {
			System.out.println("0");
			read.close();
			return;	
		}
		
		String[] letters = input.split(", ");
		Set<String> distinctLetters = new HashSet<String>();
		
		for (String letter : letters) {
			distinctLetters.add(letter);
		}
		
		System.out.println( distinctLetters.size() );
		
		// Close scanner
		read.close();
	}
	
}
