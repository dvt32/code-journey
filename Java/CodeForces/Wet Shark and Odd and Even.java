// http://codeforces.com/problemset/problem/621/A

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		Set<Integer> numbers = new TreeSet<Integer>();
		long sum = 0;
		for (int i = 0; i < n; ++i) {
			int number = read.nextInt();
			numbers.add(number);
			sum += number;
		}
		
		if (sum % 2 == 1) {
			for (int number : numbers) {
				if (number % 2 == 1) {
					sum -= number;
					break;
				}
			}
		}
		
		System.out.println(sum);
		
		// Close scanner
		read.close();
	}
	
}
