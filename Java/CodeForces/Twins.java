// http://codeforces.com/problemset/problem/160/A

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		List<Integer> coinValues = new ArrayList<Integer>();
		int minCoinCount = 0;
		
		int n = read.nextInt();
		for (int i = 0; i < n; ++i) {
			int coinValue = read.nextInt();
			coinValues.add(coinValue);
		}
		
		Collections.sort(coinValues, Collections.reverseOrder());
		
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			sum += coinValues.get(i);
			int leftOverSum = 0;
			for (int j = i+1; j < n; ++j) {
				leftOverSum += coinValues.get(j);
			}
			minCoinCount++;
			if (sum > leftOverSum) {
				break;
			}
		}
		
		System.out.println(minCoinCount);
		
		// Close scanner
		read.close();
	}
	
}
