// https://codeforces.com/problemset/problem/1114/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int x = read.nextInt(); // Andrew (eats only green grapes)
		int y = read.nextInt(); // Dmitry (eats only green and purple grapes)
		int z = read.nextInt(); // Michal (eats any grapes)
		
		int a = read.nextInt(); // green grapes
		int b = read.nextInt(); // purple grapes
		int c = read.nextInt(); // black grapes
		
		if (a >= x) {
			a -= x;
			if (a+b >= y) {
				int totalLeftGrapes = (a+b+c) - y;
				if (totalLeftGrapes >= z) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
			else {
				System.out.println("NO");
			}
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
