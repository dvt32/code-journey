// http://codeforces.com/problemset/problem/686/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		long x = read.nextLong();
		
		// Clear buffer
		read.nextLine();
		
		int numberOfDistressedKids = 0;
		for (int i = 0; i < n; ++i) {
			String line = read.nextLine();
			
			char sign = line.charAt(0);
			int number = Integer.valueOf( line.substring(2) );
			
			if (sign == '+') {
				x += number;
			}
			else { // sign == '-'
				if (x >= number) {
					x -= number;
				}
				else {
					numberOfDistressedKids++;
				}
			}
		}
		
		System.out.println(x + " " + numberOfDistressedKids);
		
		// Close scanner
		read.close();
	}
	
}
