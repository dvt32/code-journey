// https://codeforces.com/problemset/problem/363/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String n = read.nextLine();
		
		Map<Character, String> digitRods = new HashMap<>();
		digitRods.put('0', "O-|-OOOO");
		digitRods.put('1', "O-|O-OOO");
		digitRods.put('2', "O-|OO-OO");
		digitRods.put('3', "O-|OOO-O");
		digitRods.put('4', "O-|OOOO-");
		digitRods.put('5', "-O|-OOOO");
		digitRods.put('6', "-O|O-OOO");
		digitRods.put('7', "-O|OO-OO");
		digitRods.put('8', "-O|OOO-O");
		digitRods.put('9', "-O|OOOO-");
		
		for (int i = n.length()-1; i >= 0; --i) {
			char digit = n.charAt(i);
			System.out.println( digitRods.get(digit) );
		}
		
		// Close scanner
		read.close();
	}

}
