// http://codeforces.com/problemset/problem/43/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		// clear buffer
		read.nextLine();
		
		Map<String, Integer> wins = new HashMap<String, Integer>();
		
		String finalWinner = "";
		int maxWins = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			String winner = read.nextLine();
			Integer winCount = wins.get(winner);
			if (winCount == null) {
				wins.put(winner, 0);
			}
			else {
				wins.put(winner, winCount + 1);		
			}
			
			int newWinCount = wins.get(winner);
			if (newWinCount > maxWins) {
				maxWins = newWinCount;
				finalWinner = winner;
			}
		}
		
		System.out.println(finalWinner);
		
		// Close scanner
		read.close();
	}
	
}
