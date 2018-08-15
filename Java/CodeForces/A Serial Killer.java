// http://codeforces.com/problemset/problem/776/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		String[] namePair = read.nextLine().split(" ");
		
		int n = read.nextInt();
		
		read.nextLine();
		
		System.out.println(namePair[0] + " " + namePair[1]);
		for (int i = 0; i < n; ++i) {
			String[] names = read.nextLine().split(" ");
			String personMurdered = names[0];
			String replacement = names[1];	
			String newPerson = (namePair[0].equals(personMurdered) ? namePair[1] : namePair[0]);
			System.out.println(replacement + " " + newPerson);
			namePair = new String[] { replacement, newPerson };
		}
		
		// Close scanner
		read.close();
	}
}
