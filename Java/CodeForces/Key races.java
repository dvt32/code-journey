// https://codeforces.com/problemset/problem/835/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int s = read.nextInt();
		int v1 = read.nextInt();
		int v2 = read.nextInt();
		int t1 = read.nextInt();
		int t2 = read.nextInt();
		
		int playerOneTime = t1 + s*v1 + t1;
		int playerTwoTime = t2 + s*v2 + t2;
		
		if (playerOneTime < playerTwoTime) {
			System.out.println("First");
		}
		else if (playerOneTime > playerTwoTime) {
			System.out.println("Second");
		}
		else {
			System.out.println("Friendship");
		}
		
		// Close scanner
		read.close();
	}

}
