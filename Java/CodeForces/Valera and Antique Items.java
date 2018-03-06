// http://codeforces.com/problemset/problem/441/A

import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int v = read.nextInt();
		
		Set<Integer> sellersWithDeal = new TreeSet<Integer>();
		for (int i = 0; i < n; ++i) {
			int sellerIndex = (i+1);
			int itemCount = read.nextInt();
			for (int j = 0; j < itemCount; ++j) {
				int itemPrice = read.nextInt();
				if (v > itemPrice) {
					sellersWithDeal.add(sellerIndex);
				}
			}
		}
		
		System.out.println(sellersWithDeal.size());
		
		StringJoiner sellersOutput = new StringJoiner(" ");
		for (Integer seller : sellersWithDeal) {
			sellersOutput.add(String.valueOf(seller));
		}
		System.out.println(sellersOutput);
		
		// Close scanner
		read.close();
	}
	
}
