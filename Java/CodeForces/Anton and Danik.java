// http://codeforces.com/problemset/problem/734/A

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String gameCount = read.nextLine();
		String gameWinners = read.nextLine();
		int antonWinCount = 0;
		int danikWinCount = 0;
		
		for (int i = 0; i < gameWinners.length(); ++i) {
			if (gameWinners.charAt(i) == 'A') {
				antonWinCount++;
			}
			else {
				danikWinCount++;
			}
		}
		
		if (antonWinCount > danikWinCount) {
			System.out.println("Anton");
		}
		else if (antonWinCount < danikWinCount) {
			System.out.println("Danik");
		}
		else {
			System.out.println("Friendship");
		}
		
		// Close scanner
		read.close();
	}
}
