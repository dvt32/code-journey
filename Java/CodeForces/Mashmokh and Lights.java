// https://codeforces.com/problemset/problem/415/A

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		Map<Integer, Integer> turnOffButtonIndices = new TreeMap<Integer, Integer>();
		int[] b = new int[m];
		for (int i = 0; i < m; ++i) {
			b[i] = read.nextInt();
			for (int j = b[i]; j <= n; ++j) {
				if (turnOffButtonIndices.get(j) == null) {
					turnOffButtonIndices.put(j, b[i]);
				}
				else {
					break;
				}
			}
		}
		
		for (Integer turnOffButtonIndex : turnOffButtonIndices.values()) {
			System.out.print(turnOffButtonIndex + " ");
		}
		
		// Close scanner
		read.close();
	}

}
