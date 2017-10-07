// http://codeforces.com/problemset/problem/148/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int k = Integer.parseInt( read.nextLine() );
		int l = Integer.parseInt( read.nextLine() );
		int m = Integer.parseInt( read.nextLine() );
		int n = Integer.parseInt( read.nextLine() );
		int d = Integer.parseInt( read.nextLine() );
		
		boolean[] isDamagedDragon = new boolean[d];
		for (int i = k-1; i < d; i += k) {
			isDamagedDragon[i] = true;
		}
		for (int i = l-1; i < d; i += l) {
			isDamagedDragon[i] = true;
		}
		for (int i = m-1; i < d; i += m) {
			isDamagedDragon[i] = true;
		}
		for (int i = n-1; i < d; i += n) {
			isDamagedDragon[i] = true;
		}
		
		int damagedDragonCount = 0;
		for (boolean isDamaged : isDamagedDragon) {
			if (isDamaged) {
				damagedDragonCount++;
			}
		}
		
		System.out.println( damagedDragonCount );
		
		// Close scanner
		read.close();
	}
	
}
