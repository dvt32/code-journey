// https://codeforces.com/problemset/problem/622/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String[] time = read.nextLine().split(":");
		int a = read.nextInt();
		
		int hours = Integer.valueOf(time[0]);
		int minutes = Integer.valueOf(time[1]);
		
		while (a > 0) {
			a--;
			minutes = (minutes+1 > 59 ? 0 : minutes+1);
			if (minutes == 0) {
				hours = (hours+1 > 23 ? 0 : hours+1);
			}
		}
		
		System.out.println( 
			(hours < 10 ? "0"+hours : hours)
			+ ":" + 
			(minutes < 10 ? "0"+minutes : minutes)
		);

		// Close scanner
		read.close();
	}

}
