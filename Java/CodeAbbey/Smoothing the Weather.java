// http://www.codeabbey.com/index/task_view/smoothing-the-weather

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int sequenceLength = read.nextInt();
		
		double[] sequence = new double[sequenceLength];
		double[] smoothSequence = new double[sequenceLength];
		
		for (int i = 0; i < sequenceLength; ++i) {
			sequence[i] = read.nextDouble();
		}
		
		smoothSequence[0] = sequence[0];
		smoothSequence[sequenceLength-1] = sequence[sequenceLength-1];
		for (int i = 1; i < sequenceLength-1; ++i) {
			smoothSequence[i] = (sequence[i-1] + sequence[i] + sequence[i+1]) / 3;
		}
		
		for (int i = 0; i < sequenceLength; ++i) {
			System.out.print(smoothSequence[i] + " ");
		}
		
		// Close scanner
		read.close();
	}
}
