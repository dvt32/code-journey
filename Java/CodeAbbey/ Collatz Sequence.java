// http://www.codeabbey.com/index/task_view/collatz-sequence

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		// Enter number of test cases
		int numberOfTestcases = read.nextInt();
		
		// Enter value for each test case
		for (int i = 0; i < numberOfTestcases; ++i)
		{
			int x = read.nextInt();
			int numberOfSteps = 0;
			while (x != 1) 
			{
				if (x % 2 == 0) {
					x = x / 2;
				}
				else {
					x = (3*x) + 1;
				}
				numberOfSteps++;
			}
			System.out.print(numberOfSteps + " ");
		}
		
		// Close scanner
		read.close();
	}
}
