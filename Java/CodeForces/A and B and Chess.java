// http://codeforces.com/problemset/problem/519/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		final int NUMBER_OF_ROWS = 8;
		
		Map<Character, Integer> pieceValues = new HashMap<Character, Integer>();
		pieceValues.put('q', 9);
		pieceValues.put('r', 5);
		pieceValues.put('b', 3);
		pieceValues.put('n', 3);
		pieceValues.put('p', 1);
		pieceValues.put('k', 0);
		
		int whiteWeight = 0;
		int blackWeight = 0;
		for (int i = 0; i < NUMBER_OF_ROWS; ++i) {
			String input = read.nextLine().replace(".", "");
			for (int j = 0; j < input.length(); ++j) {
				char c = input.charAt(j);
				if (Character.isUpperCase(c)) {
					whiteWeight += pieceValues.get(Character.toLowerCase(c));
				}
				else {
					blackWeight += pieceValues.get(c);
				}
			}
		}
		
		if (whiteWeight > blackWeight) {
			System.out.println("White");
		}
		else if (whiteWeight < blackWeight) {
			System.out.println("Black");
		}
		else {
			System.out.println("Draw");
		}
		
		// Close scanner
		read.close();
	}
	
}
