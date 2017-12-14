// http://codeforces.com/problemset/problem/707/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		read.nextLine(); // clear buffer
		
		boolean isBlackAndWhite = true;
		for (int i = 0; i < n; ++i) {
			String[] colors = read.nextLine().split(" ");
			for (String color : colors) {
				if (!color.equals("B") && 
					!color.equals("G") &&
					!color.equals("W")) 
				{
					isBlackAndWhite = false;
					break;
				}
			}
			if (!isBlackAndWhite) {
				System.out.println("#Color");
				read.close();
				return;
			}
		}
		
		System.out.println("#Black&White");
		
		// Close scanner
		read.close();
	}
	
}
