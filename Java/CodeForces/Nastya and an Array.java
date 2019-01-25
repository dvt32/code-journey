// https://codeforces.com/problemset/problem/992/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		Set<Integer> numbers = new HashSet<Integer>();
		for (int i = 0; i < n; ++i) {
			int number = read.nextInt();
			numbers.add(number);
		}
		
		numbers.remove(0);
		
		System.out.println( numbers.size() );
		
		// Close scanner
		read.close();
	}

}
