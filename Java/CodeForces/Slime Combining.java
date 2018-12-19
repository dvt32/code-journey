// https://codeforces.com/problemset/problem/618/A

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();

		LinkedList<Integer> row = new LinkedList<Integer>();
		for (int i = 0; i < n; ++i) {
			row.add(1);
			while (row.size() > 1 && row.getLast() == row.get(row.size()-2)) {
				int v = row.removeLast();
				row.removeLast();
				row.add(v + 1);
			}
		}
		
		for (Integer value : row) {
			System.out.print(value + " ");
		}
		
		// Close scanner
		read.close();
	}

}
