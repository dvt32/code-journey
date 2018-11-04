// http://codeforces.com/problemset/problem/1030/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();

		read.nextLine();
		
		String line = read.nextLine();
		
		if (line.contains("1")) {
			System.out.println("HARD");
		}
		else {
			System.out.println("EASY");
		}
		
		// Close scanner
		read.close();
	}

}
