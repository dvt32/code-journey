// https://codeforces.com/problemset/problem/447/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int p = read.nextInt();
		int n = read.nextInt();
		
		Map<Integer, Integer> bucket = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; ++i) {
			int x = read.nextInt();
			if (bucket.containsKey(x % p)) {
				System.out.println(i+1);
				read.close();
				return;
			}
			else {
				bucket.put(x % p, x);
			}
		}
		
		System.out.println("-1");
		
		// Close scanner
		read.close();
	}

}
