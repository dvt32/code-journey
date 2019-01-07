// https://codeforces.com/problemset/problem/513/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n1 = read.nextInt();
		int n2 = read.nextInt();
		int k1 = read.nextInt();
		int k2 = read.nextInt();
		
		boolean flag = true; // true -> player 1's turn, false -> player 2's turn
		while (n1 > 0 && n2 > 0) {
			if (flag) {
				n1--;
			}
			else {
				n2--;
			}
			flag = !flag;
		}
		
		if (n1 == 0) { 
			System.out.println("Second"); 
		}
		else {
			System.out.println("First");
		}
		
		// Close scanner
		read.close();
	}

}
