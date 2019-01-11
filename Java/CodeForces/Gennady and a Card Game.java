// https://codeforces.com/problemset/problem/1097/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String cardOnTable = read.nextLine();
		String yourCards = read.nextLine();
		
		if (yourCards.contains(String.valueOf(cardOnTable.charAt(0))) || 
		    yourCards.contains(String.valueOf(cardOnTable.charAt(1))))
		{
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
