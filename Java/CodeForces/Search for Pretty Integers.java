// https://codeforces.com/problemset/problem/870/A

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		SortedSet<Integer> firstDigits = new TreeSet<Integer>();
		for (int i = 0; i < n; ++i) {
			firstDigits.add(read.nextInt());
		}
		
		SortedSet<Integer> secondDigits = new TreeSet<Integer>();
		for (int i = 0; i < m; ++i) {
			secondDigits.add(read.nextInt());
		}
		
		SortedSet<Integer> uniqueDigits = new TreeSet<Integer>();
		uniqueDigits.addAll(firstDigits);
		uniqueDigits.addAll(secondDigits);
		
		if (uniqueDigits.size() == (m+n) ) {
			if (firstDigits.first() < secondDigits.first()) {
				System.out.println(firstDigits.first() + "" + secondDigits.first());
			}
			else {
				System.out.println(secondDigits.first() + "" + firstDigits.first());
			}
		}
		else {
			firstDigits.retainAll(secondDigits);
			System.out.println(firstDigits.first());
		}
		
		// Close scanner
		read.close();
	}

}
