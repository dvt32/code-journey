// http://codeforces.com/problemset/problem/545/A

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		List<Integer> goodCarIndices = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			boolean isGoodCar = true;
			for (int j = 0; j < n; ++j) {
				int collisionResult = read.nextInt();
				if (collisionResult == 1 || collisionResult == 3) {
					isGoodCar = false;
				}
			}
			if (isGoodCar) {
				goodCarIndices.add(i+1);
			}
		}
		
		System.out.println( goodCarIndices.size() );
		for (Integer carIndex : goodCarIndices) {
			System.out.print(carIndex + " ");
		}
		
		// Close scanner
		read.close();
	}
	
}
