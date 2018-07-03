// http://codeforces.com/problemset/problem/811/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt();
		int b = read.nextInt();
		
		int numberOfGivenCandies = 1;
		String candyGiver = "a";
		String firstWhoCantGiveCandy = "";
		
		while (true) {
			if (candyGiver.equals("a")) {
				if ( (a - numberOfGivenCandies) >= 0) {
					a -= numberOfGivenCandies;
				}
				else {
					firstWhoCantGiveCandy = "Vladik";
					break;
				}
				candyGiver = "b";
			}
			else {
				if ( (b - numberOfGivenCandies) >= 0) {
					b -= numberOfGivenCandies;
				}
				else {
					firstWhoCantGiveCandy = "Valera";
					break;
				}
				candyGiver = "a";
			}
			numberOfGivenCandies++;
		}
		
		System.out.println(firstWhoCantGiveCandy);
		
		// Close scanner
		read.close();
	}
}
