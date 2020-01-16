// https://codeforces.com/problemset/problem/1220/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		String str = read.nextLine();
		
		int zCount = 0;
		int eCount = 0;
		int rCount = 0;
		int oCount = 0;
		int nCount = 0;
		for (int i = 0; i < n; ++i) {
			char c = str.charAt(i);
			switch (c) {
			case 'z': zCount++; break;
			case 'e': eCount++; break;
			case 'r': rCount++; break;
			case 'o': oCount++; break;
			case 'n': nCount++; break;
			default: break;
			}
		}
		
		while (oCount > 0 && nCount > 0 && eCount > 0) {
			oCount--;
			nCount--;
			eCount--;
			System.out.print("1 ");
		}
		while (zCount > 0 && eCount > 0 && rCount > 0 && oCount > 0) {
			zCount--;
			eCount--;
			rCount--;
			oCount--;
			System.out.print("0 ");
		}
		
		// Close scanner
		read.close();
	}

}
