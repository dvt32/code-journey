// http://codeforces.com/problemset/problem/1003/A

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			a.add(read.nextInt());
		}
		
		int pocketCount = 0;
		while (!a.isEmpty()) {
			Set<Integer> coinsInPocket = new HashSet<Integer>();
			coinsInPocket.addAll(a);
			for (Integer coin : coinsInPocket) {
				a.remove(coin);
			}
			pocketCount++;
		}
		
		System.out.println(pocketCount);
		
		// Close scanner
		read.close();
	}

}
