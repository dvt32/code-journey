// https://codeforces.com/problemset/problem/729/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt(read.nextLine());
		String s = read.nextLine();
		
		StringBuilder output = new StringBuilder();
		
		int i = 0;
		while (i < n) {
			if (i+2 < n && s.charAt(i) == 'o' && s.charAt(i+1) == 'g' && s.charAt(i+2) == 'o') {
				i += 3;
				while (i+1 < n && s.charAt(i) == 'g' && s.charAt(i+1) == 'o') {
					i += 2;
				}
				output.append("***");
			}
			else {
				output.append(s.charAt(i));
				i++;
			}
		}
		
		System.out.println(output);

		// Close scanner
		read.close();
	}

}
