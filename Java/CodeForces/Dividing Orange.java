// https://codeforces.com/problemset/problem/244/A

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		SortedSet<Integer> orangeSegments = new TreeSet<>();
		for (int i = 1; i <= n*k; ++i) {
			orangeSegments.add(i);
		}
		
		List<StringBuilder> outputLines = new ArrayList<>();
		int[] a = new int[k];
		for (int i = 0; i < k; ++i) {
			a[i] = read.nextInt();
			outputLines.add( new StringBuilder(String.valueOf(a[i])) );
			orangeSegments.remove(a[i]);
		}
		
		for (StringBuilder outputLine : outputLines) {
			for (int i = 1; i < n; ++i) {
				outputLine.append( " " + orangeSegments.last() );
				orangeSegments.remove( orangeSegments.last() );
			}
			System.out.println(outputLine);
		}
		
		// Close scanner
		read.close();
	}

}
