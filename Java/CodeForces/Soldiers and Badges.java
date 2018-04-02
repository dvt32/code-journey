// http://codeforces.com/problemset/problem/546/B

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] a = new int[n];
		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			uniqueNumbers.add(a[i]);
		}
		
		Arrays.sort(a);
		
		int numberOfNeededCoins = 0;
		for (int i = 1; i < n; ++i) {
			if (a[i] == a[i-1]) {
				a[i]++;
				numberOfNeededCoins++;
			}
			else if (a[i] < a[i-1]) {
				int differenceBetweenElements = a[i-1] - a[i];
				a[i] += differenceBetweenElements;
				numberOfNeededCoins += differenceBetweenElements;
				a[i]++;
				numberOfNeededCoins++;			
			}
		}
		
		System.out.println(numberOfNeededCoins);
		
		// Close scanner
		read.close();
	}
	
}
