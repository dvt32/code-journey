// https://codeforces.com/problemset/problem/847/G

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 7; ++i) {
			map.put(i, 0);
		}
		
		int minNumberOfRoomsNeeded = 0;
		for (int i = 0; i < n; ++i) {
			String sequence = read.nextLine();
			for (int j = 0; j < 7; ++j) {
				int digit = Character.getNumericValue(sequence.charAt(j));
				if (digit == 1) {
					map.put(j, map.get(j)+1);
					minNumberOfRoomsNeeded = Math.max(minNumberOfRoomsNeeded, map.get(j));
				}
			}
		}
		
		System.out.println(minNumberOfRoomsNeeded);
		
		// Close scanner
		read.close();
	}

}
