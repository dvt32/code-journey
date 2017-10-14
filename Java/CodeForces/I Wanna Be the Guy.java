// http://codeforces.com/problemset/problem/469/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		int[] pLevelIndices = Arrays.stream( read.nextLine().split(" ") ).mapToInt(Integer::parseInt).toArray();
		int[] qLevelIndices = Arrays.stream( read.nextLine().split(" ") ).mapToInt(Integer::parseInt).toArray();
		
		boolean[] levelCanBePassed = new boolean[n];
		for (int i = 1; i < pLevelIndices.length; ++i) {
			int passedLevelIndex = pLevelIndices[i]-1;
			levelCanBePassed[passedLevelIndex] = true;
		}
		for (int i = 1; i < qLevelIndices.length; ++i) {
			int passedLevelIndex = qLevelIndices[i]-1;
			levelCanBePassed[passedLevelIndex] = true;
		}
		
		for (int i = 0; i < levelCanBePassed.length; ++i) {
			if ( !levelCanBePassed[i] ) {
				System.out.println("Oh, my keyboard!");
				read.close();
				return;
			}
		}
		
		System.out.println("I become the guy.");
			
		// Close scanner
		read.close();
	}
	
}
