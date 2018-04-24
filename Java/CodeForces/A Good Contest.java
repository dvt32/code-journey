// http://codeforces.com/problemset/problem/681/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		read.nextLine(); // clear buffer
		
		boolean isGoodContest = false;
		for (int i = 0; i < n; ++i) {
			String[] line = read.nextLine().split(" ");
			
			String name = line[0];
			int before = Integer.parseInt(line[1]);
			int after = Integer.parseInt(line[2]);
			
			if (before >= 2400 && after > before) {
				isGoodContest = true;
				break;
			}
		}
		
		if (isGoodContest) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
