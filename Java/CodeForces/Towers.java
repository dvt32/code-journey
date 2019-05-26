// https://codeforces.com/problemset/problem/37/A

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] l = new int[n];
		Set<Integer> uniqueBarLengths = new HashSet<>();
		Map<Integer, Integer> barLengthFrequencies = new HashMap<>();
		int maxTowerSize = 0;
		
		for (int i = 0; i < n; ++i) {
			l[i] = read.nextInt();
			uniqueBarLengths.add(l[i]);
			Integer barLengthFrequency = barLengthFrequencies.get(l[i]);
			if (barLengthFrequency == null) {
				barLengthFrequencies.put(l[i], 1);
			}
			else {
				barLengthFrequencies.put(l[i], barLengthFrequency+1);
			}
			maxTowerSize = Math.max(maxTowerSize, barLengthFrequencies.get(l[i]));
		}
		
		System.out.println( 
			maxTowerSize
			+ " " + 
			uniqueBarLengths.size() 
		);
		
		// Close scanner
		read.close();
	}

}
