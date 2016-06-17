// http://www.codeabbey.com/index/task_view/bicycle-race

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int testCases = read.nextInt();
		
		// Enter 'S', 'A', 'B' and calculate distance
		for (int i = 0; i < testCases; ++i) {
			double distance = read.nextInt();
			double speed_A = read.nextInt();
			double speed_B = read.nextInt();
			double time = distance / (speed_A + speed_B);
			double meetDistance = time * speed_A;
			System.out.print(meetDistance + " ");
		}
		
		// Close scanner
		read.close();
	}
}
