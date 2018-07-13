// http://codeforces.com/problemset/problem/152/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int m = read.nextInt();
		
		read.nextLine();
		
		String[] marksOfStudents = new String[n];
		for (int i = 0; i < n; ++i) {
			marksOfStudents[i] = read.nextLine();
		}
		
		boolean[] isSuccessful = new boolean[n];
		for (int subjectIndex = 0; subjectIndex < m; ++subjectIndex) {
			char maxMark = '0';
			for (int i = 0; i < n; ++i) {
				if (marksOfStudents[i].charAt(subjectIndex) > maxMark) {
					maxMark = marksOfStudents[i].charAt(subjectIndex);
				}
			}
			for (int i = 0;i < n; ++i) {
				if (marksOfStudents[i].charAt(subjectIndex) == maxMark) {
					isSuccessful[i] = true;
				}
			}
		}
		
		int numberOfSuccessfulStudents = 0;
		for (int i = 0; i < n; ++i) {
			if (isSuccessful[i]) {
				numberOfSuccessfulStudents++;
			}
		}
		
		System.out.println(numberOfSuccessfulStudents);
		
		// Close scanner
		read.close();
	}
}
