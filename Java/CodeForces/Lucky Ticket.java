// http://codeforces.com/problemset/problem/146/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		read.nextLine();
		
		String ticketNumber = read.nextLine();
		boolean isLuckyNumber = true;
		
		for (int i = 0; i < n; ++i) {
			char c = ticketNumber.charAt(i);
			if (c != '4' && c != '7') {
				isLuckyNumber = false;
				break;
			}
		}
		
		if (isLuckyNumber) {
			int firstHalfSum = 0;
			for (int i = 0; i < n/2; ++i) {
				char c = ticketNumber.charAt(i);
				firstHalfSum += Character.getNumericValue(c);
			}
			
			int secondHalfSum = 0;
			for (int i = n/2; i < n; ++i) {
				char c = ticketNumber.charAt(i);
				secondHalfSum += Character.getNumericValue(c);
			}
			boolean isLuckyTicket = (firstHalfSum == secondHalfSum);
			if (isLuckyTicket) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
