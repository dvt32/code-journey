// https://codeforces.com/problemset/problem/48/A

import java.util.Scanner;

public class Solution {
	
	private static boolean isWinner(String player, String opponent1, String opponent2) {
		boolean isWinner = false;
		
		switch (player) {
		case "rock": 
			if (opponent1.equals("scissors") && opponent2.equals("scissors")) {
				isWinner = true;
			}
			break;
		case "paper": 
			if (opponent1.equals("rock") && opponent2.equals("rock")) {
				isWinner = true;
			}
			break;
		case "scissors": 
			if (opponent1.equals("paper") && opponent2.equals("paper")) {
				isWinner = true;
			}
			break;
		}
		
		return isWinner;
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String f = read.nextLine();
		String m = read.nextLine();
		String s = read.nextLine();
	
		if (isWinner(f, m, s)) {
			System.out.println("F");
		}
		else if (isWinner(m, f, s)) {
			System.out.println("M");
		}
		else if (isWinner(s, f, m)) {
			System.out.println("S");
		}
		else {
			System.out.println("?");
		}
		
		// Close scanner
		read.close();
	}

}
