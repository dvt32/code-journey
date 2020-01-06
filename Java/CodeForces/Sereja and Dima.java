// https://codeforces.com/problemset/problem/381/A

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		LinkedList<Integer> cardValues = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			cardValues.add( read.nextInt() );
		}
		
		int serejaPoints = 0;
		int dimaPoints = 0;
		String currentPlayer = "Sereja";
		
		while (cardValues.size() != 0) {
			int maxValue = Math.max( cardValues.getFirst(), cardValues.getLast() );
			
			if (maxValue == cardValues.getFirst()) {
				cardValues.removeFirst();
			}
			else {
				cardValues.removeLast();
			}
			
			if (currentPlayer.equals("Sereja")) {
				serejaPoints += maxValue;
				currentPlayer = "Dima";
			}
			else {
				dimaPoints += maxValue;
				currentPlayer = "Sereja";
			}
		}
		
		System.out.println( serejaPoints + " " + dimaPoints );
	
		// Close scanner
		read.close();
	}

}
