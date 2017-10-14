// http://codeforces.com/problemset/problem/116/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int minTramCapacityNeeded = 0;
		int numberOfPassengersInTram = 0;
		
		int n = Integer.parseInt( read.nextLine() );
		for (int i = 0; i < n; ++i) {
			String[] lineData = read.nextLine().split(" ");
			int aI = Integer.parseInt( lineData[0] );
			int bI = Integer.parseInt( lineData[1] );
			numberOfPassengersInTram -= aI;
			numberOfPassengersInTram += bI;
			if (numberOfPassengersInTram > minTramCapacityNeeded) {
				minTramCapacityNeeded = numberOfPassengersInTram;
			}
		}
		
		System.out.println( minTramCapacityNeeded );
			
		// Close scanner
		read.close();
	}
	
}
