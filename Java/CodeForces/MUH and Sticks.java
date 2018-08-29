// http://codeforces.com/problemset/problem/471/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		Map<Integer, Integer> stickLengthFrequencies = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < 6; ++i) {
			int l = read.nextInt();
			
			Integer stickLengthFrequency = stickLengthFrequencies.get(l);
			if (stickLengthFrequency == null) {
				stickLengthFrequencies.put(l, 1);
			}
			else {
				stickLengthFrequencies.put(l, stickLengthFrequency+1);
			}
		}
		
		// Close scanner
		read.close();
		
		boolean legsFound = false;
		for (Integer stickLength: stickLengthFrequencies.keySet()) {
			Integer currentStickLengthFrequencies = stickLengthFrequencies.get(stickLength);
			if (currentStickLengthFrequencies >= 4) {
				legsFound = true;
				stickLengthFrequencies.put(stickLength, currentStickLengthFrequencies-4);
				break;
			}
		}
		
		if (!legsFound) {
			System.out.println("Alien");
		}
		else {
			int a = 0;
			int b = 0;
			for (Integer stickLength: stickLengthFrequencies.keySet()) {
				Integer currentStickLengthFrequencies = stickLengthFrequencies.get(stickLength);
				if (currentStickLengthFrequencies == 2) {
					a = stickLength;
					b = stickLength;
					break;
				}
				else if (currentStickLengthFrequencies == 1) {
					if (a == 0) {
						a = stickLength;
						continue;
					}
					if (b == 0) {
						b = stickLength;
						break;
					}
				}
			}
			
			if (a == b) {
				System.out.println("Elephant");
				return;
			}
			else {
				System.out.println("Bear");
			}
		}
	}
	
}
