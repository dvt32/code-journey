// http://codeforces.com/problemset/problem/349/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int[] bills = new int[2];
		
		// bills[0] - number of 25 dollar bills
		// bills[1] - number of 50 dollar bills
		// Note: it is not needed to keep track of the 100 dollar bills
		
		boolean canSellTickets = true;
		for (int i = 0; i < n; ++i) {
			int bill = read.nextInt();
			if (bill == 25) {
				bills[0]++;
			}
			else if (bill == 50) {
				bills[0]--;
				bills[1]++;
			}
			else if (bill == 100) {
				if (bills[1] > 0) {
					bills[1]--;
					bills[0]--;
				}
				else {
					bills[0] -= 3;
				}
			}
			
			if (bills[0] < 0) {
				canSellTickets = false;
				break;
			}
		}
		
		if (canSellTickets) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
