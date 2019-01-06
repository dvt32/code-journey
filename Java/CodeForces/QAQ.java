// https://codeforces.com/problemset/problem/894/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		int n = s.length();
		
		int subsequenceCount = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i+1; j < n; ++j) {
				for (int k = j+1; k < n; ++k) {
					if (s.charAt(i) == 'Q' &&
						s.charAt(j) == 'A' &&
						s.charAt(k) == 'Q') 
					{
						subsequenceCount++;
					}
				}
			}
		}
		
		System.out.println(subsequenceCount);
		
		// Close scanner
		read.close();
	}

}
