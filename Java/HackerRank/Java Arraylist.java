// https://www.hackerrank.com/challenges/java-arraylist

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		List<List<Integer>> numbers = new ArrayList<List<Integer>>();
		
		// Enter numbers
		int n = read.nextInt();
		numbers.add(new ArrayList<Integer>());
		numbers.get(0).add(n);
		
		for (int i = 1; i <= n; ++i) {
			numbers.add(new ArrayList<Integer>());
			int d = read.nextInt();
			numbers.get(i).add(d);
			for (int j = 0; j < d; ++j) {
				int number = read.nextInt();
				numbers.get(i).add(number);
			}
		}
		
		// Enter queries
		int q = read.nextInt();
		for (int i = 0; i < q; ++i) {
			int x = read.nextInt();
			int y = read.nextInt();
			if (x >= numbers.size() || 
				x < 0 || 
				y >= numbers.get(x).size() || 
				y < 0) 
			{
				System.out.println("ERROR!");
			}
			else {
				System.out.println(numbers.get(x).get(y));
			}
		}
		
		// Close scanner
		read.close();
	}
}
