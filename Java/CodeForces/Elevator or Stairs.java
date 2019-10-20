// https://codeforces.com/problemset/problem/1054/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int x = read.nextInt();
		int y = read.nextInt();
		int z = read.nextInt();
		int t1 = read.nextInt();
		int t2 = read.nextInt();
		int t3 = read.nextInt();
		
		int timeRequiredWithStairs = Math.abs(x-y) * t1;
 				
		int timeRequiredWithElevator = 
			(Math.abs(x-z) * t2) + // time for elevator to reach Masha's floor
			t3 + t3 + // time for elevator to open and close doors (so Masha can enter the elevator)
			(Math.abs(x-y) * t2) + // time for elevator to reach Masha's target floor
			t3; // time for elevator to open (so Masha can leave the elevator)
		
		System.out.println(
			!(timeRequiredWithElevator > timeRequiredWithStairs)
			? "YES"
			: "NO"
		);
		
		// Close scanner
		read.close();
	}

}
