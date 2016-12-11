// https://community.topcoder.com/stat?c=problem_statement&pm=6528

import java.util.Arrays;

public class MedianOfNumbers {
	public static int findMedian(int[] numbers) {
		Arrays.sort(numbers);

		int median = numbers[numbers.length / 2];
		
		if ((numbers.length / 2) == (numbers.length - (numbers.length / 2) - 1)) {
			return median;
		}
		else {
			return -1;
		}
	}
}
