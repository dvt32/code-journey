// https://codeforces.com/problemset/problem/205/A

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		if (n == 1) {
			System.out.println("1");
			read.close();
			return;
		}
		
		int[] times = new int[n];
		Map<Integer, Integer> timeIndices = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; ++i) {
			times[i] = read.nextInt();
			timeIndices.put(times[i], i+1);
		}
		
		Arrays.sort(times);
		
		if (times[0] != times[1]) {
			System.out.println(timeIndices.get(times[0]));
		}
		else {
			System.out.println("Still Rozdil");
		}
		
		// Close scanner
		read.close();
	}

}
