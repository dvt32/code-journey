// https://codeforces.com/problemset/problem/1056/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
	
		Set<Integer> commonLineNumbers = new HashSet<Integer>();
		for (int i = 0; i < n; ++i) {
			int r = read.nextInt();
			Set<Integer> lineNumbers = new HashSet<Integer>();
			for (int j = 0; j < r; ++j) {
				int lineNumber = read.nextInt();
				lineNumbers.add(lineNumber);
			}	
			if (commonLineNumbers.isEmpty()) {
				commonLineNumbers.addAll(lineNumbers);
			}
			else {
				commonLineNumbers.retainAll(lineNumbers);
			}
		}

		for (Integer lineNumber : commonLineNumbers) {
			System.out.print(lineNumber + " ");
		}
		
		// Close scanner
		read.close();
	}

}
