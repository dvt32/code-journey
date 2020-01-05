// https://codeforces.com/problemset/problem/1173/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int x = read.nextInt(); // + votes
		int y = read.nextInt(); // - votes
		int z = read.nextInt(); // ? votes
		
		if (x > y+z) {
			System.out.println("+");
		}
		else if (y > x+z) {
			System.out.println("-");
		}
		else if (x == y) {
			System.out.println( z == 0 ? "0" : "?" );
		}
		else {
			System.out.println("?");
		}
	
		// Close scanner
		read.close();
	}

}
