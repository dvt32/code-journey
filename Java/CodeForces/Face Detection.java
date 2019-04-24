// https://codeforces.com/problemset/problem/549/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		read.nextLine();
		
		String[] image = new String[n];
		for (int i = 0; i < n; ++i) {
			image[i] = read.nextLine();
		}
		
		int faceCount = 0;
		for (int i = 0; i < n-1; ++i) {
			for (int j = 0; j < m-1; ++j) {
				char firstLetterOfFirstRow = image[i].charAt(j);
				char secondLetterOfFirstRow = image[i].charAt(j+1);
				char firstLetterOfSecondRow = image[i+1].charAt(j);
				char secondLetterOfSecondRow = image[i+1].charAt(j+1);
				char[] letters = new char[] {
					firstLetterOfFirstRow,
					secondLetterOfFirstRow,
					firstLetterOfSecondRow,
					secondLetterOfSecondRow
				};
				Arrays.sort(letters);
				if (String.valueOf(letters).equals("acef")) {
					faceCount++;
				}
			}
		}
		
		System.out.println(faceCount);
		
		// Close scanner
		read.close();
	}

}
