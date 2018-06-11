// http://codeforces.com/problemset/problem/939/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		Map<Integer, Integer> lovedPlanes = new HashMap<Integer, Integer>();
		for (int i = 1; i <= n; ++i) {
			lovedPlanes.put(i, read.nextInt());
		}
		
		boolean thereIsLoveTriangle = false;
		for (int i = 0; i < lovedPlanes.size(); ++i) {
			int a = lovedPlanes.get(i+1); // planes are numbered from 1 to 'n'
			int b = lovedPlanes.get(a); // plane loved by A is B
			int c = lovedPlanes.get(b); // plane loved by B is C
			
			if (lovedPlanes.get(c) == a) {
				thereIsLoveTriangle = true;
				break;
			}
		}
		
		if (thereIsLoveTriangle) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
}
