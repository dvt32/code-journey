// http://codeforces.com/problemset/problem/780/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		Map<Integer, Integer> bag = new HashMap<Integer, Integer>();
		for (int i = 1; i <= n; ++i) {
			bag.put(i, 2);
		}
		
		int maxNumberOfSocksOnTable = 0;
		int numberOfSocksOnTable = 0;
		
		for (int i = 0; i < 2*n; ++i) {
			int x = read.nextInt();
			
			Integer numberOfPairXSocksInBag = bag.get(x);
			if (numberOfPairXSocksInBag == 2) {
				bag.put(x, 1);
				numberOfSocksOnTable++;
			}
			else {
				numberOfSocksOnTable--;
			}
			
			maxNumberOfSocksOnTable = Math.max(maxNumberOfSocksOnTable, numberOfSocksOnTable);
		}
		
		System.out.println(maxNumberOfSocksOnTable);
		
		// Close scanner
		read.close();
	}
}
