// http://codeforces.com/problemset/problem/721/A

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		// Enter input
		int n = read.nextInt();
		read.nextLine(); // clear buffer
		String line = read.nextLine();
		
		int k = 0; // number of black square groups
		List<Integer> blackSquareGroupSizes = new ArrayList<Integer>();
		int i = 0;
		while (i < line.length()) {
			int currentGroupSize = 0;
			if (line.charAt(i) == 'B') {
				while (i < line.length() && line.charAt(i) == 'B') {
					i++;
					currentGroupSize++;
				}
				blackSquareGroupSizes.add(currentGroupSize);
				k++;
			}
			else {
				i++;
			}
		}
		
		// Print output
		System.out.println(k);
		for (Integer size : blackSquareGroupSizes) {
			System.out.print(size + " ");
		}
		
		// Close scanner
		read.close();
	}
	
}
