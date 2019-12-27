// https://codeforces.com/problemset/problem/1207/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int t = read.nextInt();
		for (int i = 0; i < t; ++i) {
			int b = read.nextInt(); // buns
			int p = read.nextInt(); // beef patties
			int f = read.nextInt(); // chicken cutlets
			
			// 1 hamburger = 2 buns + 1 beef patty
			// 1 chicken burger = 2 buns + 1 chicken cutlet
			
			int h = read.nextInt(); // hamburger price
			int c = read.nextInt(); // chicken burger price
			
			int hamburgerCount = 0;
			int chickenBurgerCount = 0;
			if (h > c) {
				hamburgerCount = Math.min(p, b / 2);
				b -= 2 * hamburgerCount; // every burger requires 2 buns to make
				chickenBurgerCount = Math.min(f, b / 2);
			}
			else {
				chickenBurgerCount = Math.min(f, b / 2);
				b -= 2 * chickenBurgerCount;
				hamburgerCount = Math.min(p, b / 2);
			}
			
			int maxProfit = (hamburgerCount * h) + (chickenBurgerCount * c);
			System.out.println(maxProfit);
		}
		
		// Close scanner
		read.close();
	}

}
