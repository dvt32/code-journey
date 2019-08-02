// https://codeforces.com/problemset/problem/653/A

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		SortedSet<Integer> distinctBallSizes = new TreeSet<>();
		
		int[] t = new int[n];
		for (int i = 0; i < n; ++i) {
			t[i] = read.nextInt();
			distinctBallSizes.add(t[i]);
		}
		
		List<Integer> ballSizes = new ArrayList<>(distinctBallSizes);
		boolean foundValidBalls = false;
		for (int i = 1; i < distinctBallSizes.size()-1; ++i) {
			int firstDifference = Math.abs(ballSizes.get(i) - ballSizes.get(i-1));
			int secondDifference = Math.abs(ballSizes.get(i) - ballSizes.get(i+1));
			int thirdDifference = Math.abs(ballSizes.get(i-1) - ballSizes.get(i+1));
			if (firstDifference <= 2 && secondDifference <= 2 && thirdDifference <= 2) {
				foundValidBalls = true;
				break;
			}
		}
		
		System.out.println( foundValidBalls ? "YES" : "NO" );
		
		// Close scanner
		read.close();
	}

}
