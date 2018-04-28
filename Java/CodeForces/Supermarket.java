// http://codeforces.com/problemset/problem/919/A

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		SortedSet<Double> prices = new TreeSet<Double>();
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			int b = read.nextInt();
			prices.add( (double) a / b );
		}
		
		System.out.println( prices.first() * m );
		
		// Close scanner
		read.close();
	}
	
}
