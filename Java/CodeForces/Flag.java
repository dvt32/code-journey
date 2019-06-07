// https://codeforces.com/problemset/problem/16/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		read.nextLine();
		
		String[] rows = new String[n];
		for (int i = 0; i < n; ++i) {
			rows[i] = read.nextLine();
		}
		
		boolean meetsIsoStandard = true;
		for (int i = 0; i < n; ++i) {
			char[] squareColorsOnRow = rows[i].toCharArray();
			
			Set<Character> uniqueSquareColorsOnRow = new HashSet<Character>();
			for (Character color : squareColorsOnRow) {
				uniqueSquareColorsOnRow.add(color);
			}
			
			if (uniqueSquareColorsOnRow.size() != 1) {
				meetsIsoStandard = false;
				break;
			}
			
			char currentColor = squareColorsOnRow[0];
			char previousColor = (i-1 >= 0) ? rows[i-1].charAt(0) : ' ';
			char nextColor = (i+1 < n) ? rows[i+1].charAt(0) : ' ';
			
			if (currentColor == previousColor || currentColor == nextColor) {
				meetsIsoStandard = false; 
				break;
			}	
		}
		
		if (meetsIsoStandard) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
