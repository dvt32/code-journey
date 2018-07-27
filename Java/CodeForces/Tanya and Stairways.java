// https://codeforces.com/problemset/problem/1005/A

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		int numberOfStairways = 0;
		List<Integer> stairwayLengths =  new ArrayList<>();
		
		int i = 0;
		while (i < n) {
			if (a[i] == 1) {
				numberOfStairways++;
				i++;
				
				int stairwayLength = 1;
				while (i < n && a[i] != 1) {
					stairwayLength++;
					i++;
				}
				
				stairwayLengths.add(stairwayLength);
			}
		}
		
		System.out.println(numberOfStairways);
		for (Integer stairwayLength : stairwayLengths) {
			System.out.print(stairwayLength + " ");
		}
		
		// Close scanner
		read.close();
	}
}
