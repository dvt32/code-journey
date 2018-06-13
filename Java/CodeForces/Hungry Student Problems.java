// http://codeforces.com/problemset/problem/903/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		for (int i = 0; i < n; ++i) {
			int x = read.nextInt();
			
			boolean canBuyXChunks = false;
			for (int a = 0; a <= 33; ++a) { // 33 is max value for 'a' before 3*a becomes > 100
				for (int b = 0; b <= 14; ++b) { // 14 is max value for 'b' before 7*b becomes > 100
					if ( (3*a + 7*b) == x ) {
						canBuyXChunks = true;
						break;
					}
				}
				if (canBuyXChunks) {
					break;
				}
			}
			
			if (canBuyXChunks) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		
		// Close scanner
		read.close();
	}
}
