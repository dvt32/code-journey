// https://codeforces.com/problemset/problem/1200/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		String s = read.nextLine();
		
		StringBuilder assignmentStatus = new StringBuilder();
		for (int i = 0; i <= 9; ++i) {
			assignmentStatus.append('0');
		}
		
		for (int i = 0; i < n; ++i) {
			char c = s.charAt(i);
			if (c == 'L') {
				int j = 0;
				while (assignmentStatus.charAt(j) == '1') {
					j++;
				}
				assignmentStatus.setCharAt(j, '1');
			}
			else if (c == 'R') {
				int j = 9;
				while (assignmentStatus.charAt(j) == '1') {
					j--;
				}
				assignmentStatus.setCharAt(j, '1');
			}
			else {
				assignmentStatus.setCharAt(Character.getNumericValue(c), '0');
			}
		}
		
		System.out.println(assignmentStatus);
		
		// Close scanner
		read.close();
	}

}
