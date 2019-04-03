// https://codeforces.com/problemset/problem/137/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		
		final int MAX_NUMBER_OF_CARRIED_ITEMS = 5;
		int minNumberOfClosetVisits = 0;
		
		int i = 0;
		while (i < s.length()) {
			int numberOfCarriedItems = 1;
			i++;
			while (i < s.length() && 
				   s.charAt(i) == s.charAt(i-1) && 
				   numberOfCarriedItems < MAX_NUMBER_OF_CARRIED_ITEMS) 
			{
				i++;
				numberOfCarriedItems++;
			}
			minNumberOfClosetVisits++;
		}
		
		System.out.println(minNumberOfClosetVisits);

		// Close scanner
		read.close();
	}

}
