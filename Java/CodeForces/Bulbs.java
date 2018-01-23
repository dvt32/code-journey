// http://codeforces.com/problemset/problem/615/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		Set<Integer> turnedOnBulbs = new HashSet<Integer>();
		for (int i = 0; i < n; ++i) {
			int x = read.nextInt();
			for (int y = 0; y < x; ++y) {
				turnedOnBulbs.add(read.nextInt());
			}
		}
		
		if (turnedOnBulbs.size() == m) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
