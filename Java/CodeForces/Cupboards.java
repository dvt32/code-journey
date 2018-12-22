// https://codeforces.com/problemset/problem/248/A

// Simplified solution (not by me: https://github.com/fuwutu/CodeForces/blob/master/248A%20-%20Cupboards.cpp)

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		Map<Integer, Integer> leftDoorFrequencies = new HashMap<>();
		leftDoorFrequencies.put(0, 0);
		leftDoorFrequencies.put(1, 0);
		
		Map<Integer, Integer> rightDoorFrequencies = new HashMap<>();
		rightDoorFrequencies.put(0, 0);
		rightDoorFrequencies.put(1, 0);
		
		for (int i = 0; i < n; ++i) {
			int l = read.nextInt();
			int r = read.nextInt();	
			leftDoorFrequencies.put(l, leftDoorFrequencies.get(l)+1);
			rightDoorFrequencies.put(r, rightDoorFrequencies.get(r)+1);
		}
		
		int leftMin = Math.min(leftDoorFrequencies.get(0), leftDoorFrequencies.get(1));
		int rightMin = Math.min(rightDoorFrequencies.get(0), rightDoorFrequencies.get(1));
		
		System.out.println( leftMin + rightMin );
		
		// Close scanner
		read.close();
	}

}
