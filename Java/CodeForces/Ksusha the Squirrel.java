// https://codeforces.com/problemset/problem/299/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		read.nextLine();
		
		String road = read.nextLine();
		
		int i = 0;
		int maxRockSegmentLength = 0;
		while (i < n) {
			char c = road.charAt(i);
			if (c == '#') {
				int currentRockSegmentLength = 0;
				while (i < n && road.charAt(i) == '#') {
					currentRockSegmentLength++;
					i++;
				}
				maxRockSegmentLength = Math.max(maxRockSegmentLength, currentRockSegmentLength);
			}
			i++;
		}

		boolean canReachEnd = (maxRockSegmentLength < k);
		System.out.println( canReachEnd ? "YES" : "NO" );
		
		// Close scanner
		read.close();
	}

}
