// http://codeforces.com/problemset/problem/245/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int firstServerReachedPacketCount = 0;
		int firstServerLostPacketCount = 0;
		int secondServerReachedPacketCount = 0;
		int secondServerLostPacketCount = 0;
		
		for (int i = 0; i < n; ++i) {
			int t = read.nextInt();
			int x = read.nextInt();
			int y = read.nextInt();
			
			if (t == 1) {
				firstServerReachedPacketCount += x;
				firstServerLostPacketCount += y;
			}
			else {
				secondServerReachedPacketCount += x;
				secondServerLostPacketCount += y;
			}
		}
		
		int firstServerTotalPacketCount = firstServerReachedPacketCount + firstServerLostPacketCount;
		if ( firstServerReachedPacketCount >= (firstServerTotalPacketCount / 2) ) {
			System.out.println("LIVE");
		}
		else {
			System.out.println("DEAD");
		}
		
		int secondServerTotalPacketCount = secondServerReachedPacketCount + secondServerLostPacketCount;
		if ( secondServerReachedPacketCount >= (secondServerTotalPacketCount / 2) ) {
			System.out.println("LIVE");
		}
		else {
			System.out.println("DEAD");
		}
		
		// Close scanner
		read.close();
	}

}
