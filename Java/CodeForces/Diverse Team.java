// http://codeforces.com/problemset/problem/988/A

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int k = read.nextInt();
		
		Set<Integer> ratings = new HashSet<Integer>();
		Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; ++i) {
			int rating = read.nextInt();
			ratings.add(rating);
			indices.put(rating, i+1);
		}
		
		if (ratings.size() < k) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
			int teamLength = 0;
			for (Integer rating : ratings) {
				if (teamLength == k) {
					break;
				}
				System.out.print( indices.get(rating) + " " );
				teamLength++;
			}
		}
		
		// Close scanner
		read.close();
	}
}
