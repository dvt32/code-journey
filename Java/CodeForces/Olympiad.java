// https://codeforces.com/problemset/problem/937/A

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		Set<Integer> scores = new TreeSet<Integer>();
		for (int i = 0; i < n; ++i) {
			int score = read.nextInt();
			scores.add(score);
		}
		
		scores.remove(0);
		
		System.out.println(scores.size());
		
		// Close scanner
		read.close();
	}
}
