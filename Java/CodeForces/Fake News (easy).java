// https://codeforces.com/problemset/problem/802/G

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		
		int hIndex = s.indexOf('h');
		int eIndex = s.indexOf('e', hIndex);
		int iIndex = s.indexOf('i', eIndex);
		int dIndex = s.indexOf('d', iIndex);
		int iIndex_second = s.indexOf('i', dIndex);
		
		if (hIndex != -1 &&
			eIndex != -1 &&
			iIndex != -1 &&
			dIndex != -1 &&
			iIndex_second != -1) 
		{
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
