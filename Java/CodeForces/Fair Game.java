// https://codeforces.com/problemset/problem/864/A

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
	
		SortedSet<Integer> uniqueNumbers = new TreeSet<>();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			uniqueNumbers.add(a[i]);
		}

		if (uniqueNumbers.size() == 2) {
			int firstNumber = uniqueNumbers.first();
			int secondNumber = uniqueNumbers.last();
			int firstNumberCount = 0;
			int secondNumberCount = 0;
			
			for (int i = 0; i < n; ++i) {
				if (a[i] == firstNumber) { firstNumberCount++; }
				else if (a[i] == secondNumber) { secondNumberCount++; }
			}
			
			if (firstNumberCount == secondNumberCount) {
				System.out.println("YES");
				System.out.println( uniqueNumbers.first() + " " + uniqueNumbers.last() );
			}
			else {
				System.out.println("NO");
			}
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
