// http://www.codeabbey.com/index/task_view/neumanns-random-generator

// Sorry for posting this... :(

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int numberOfTestcases = read.nextInt();
		for (int i = 0; i < numberOfTestcases; ++i) {
			Set<Integer> sequence = new HashSet<Integer>();
			int number = read.nextInt();
			sequence.add(number);
			int numberOfIterations = 0;
			do
			{
				number = number * number;
				String numberToString = String.format("%08d", number);
				number = Integer.parseInt(numberToString.substring(2, 6));
				numberOfIterations++;
			}
			while (sequence.add(number));
			System.out.print(numberOfIterations + " ");
		}
		
		// Close scanner
		read.close();
	}
}
