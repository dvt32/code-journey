// http://codeforces.com/problemset/problem/962/A

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		int totalNumberOfProblems = IntStream.of(a).sum();
		int halfOfNumberOfProblems = 
			(totalNumberOfProblems % 2 == 0) 
			? (totalNumberOfProblems/2)
			: (totalNumberOfProblems/2) + 1;
	
		int numberOfProblems = 0;
		int dayIndex = 0;
		for (int i = 0; i < n; ++i) {
			numberOfProblems += a[i];
			dayIndex++;
			if (numberOfProblems >= halfOfNumberOfProblems) {
				break;
			}
		}
		
		System.out.println(dayIndex);
		
		// Close scanner
		read.close();
	}
}
