// http://codeforces.com/problemset/problem/1015/A

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int m = read.nextInt();
		
		Map<Integer, Boolean> endPointIsInSegment = new HashMap<Integer, Boolean>();
		for (int i = 1; i <= m; ++i) {
			endPointIsInSegment.put(i, false);
		}
		
		for (int i = 0; i < n; ++i) {
			int l = read.nextInt();
			int r = read.nextInt();
			
			for (int j = l; j <= r; ++j) {
				endPointIsInSegment.put(j, true);
			}
		}
		
		int k = 0;
		List<Integer> endPoints = new ArrayList<Integer>();
		for (Integer endPoint : endPointIsInSegment.keySet()) {
			if (!endPointIsInSegment.get(endPoint)) {
				k++;
				endPoints.add(endPoint);
			}
		}
		
		System.out.println(k);
		for (Integer endPoint : endPoints) {
			System.out.print(endPoint + " ");
		}
		
		// Close scanner
		read.close();
	}
}
