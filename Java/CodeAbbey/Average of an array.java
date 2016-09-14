// http://www.codeabbey.com/index/task_view/average-of-array

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int numberOfTestcases = read.nextInt();
		
		for (int i = 0; i < numberOfTestcases; ++i) {
			int sum = 0;
			int numberCount = 0;
			int number = -1;
			do {
				number = read.nextInt();
				sum += number;
				numberCount++;
			}
			while (number != 0);
			
			numberCount--;
			
			if (numberCount > 0) {
				int average = (int) Math.round((double) sum / numberCount);
				System.out.print(average + " ");
			}
		}
		
		// Close scanner
		read.close();
	}

}
