// https://community.topcoder.com/stat?c=problem_statement&pm=6442

public class StringSegment {
	public static double average(String s) {
		int totalSequenceLength = 0;
		int sequenceCount = 0;
		
		char currentSequenceChar = s.charAt(0);
		int currentSequenceLength = 0;
		
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == currentSequenceChar) {
				currentSequenceLength++;
			}
			else {
				totalSequenceLength += currentSequenceLength;
				sequenceCount++;
				
				currentSequenceLength = 1;
				currentSequenceChar = s.charAt(i);
				
				if (i == s.length()-1) {
					totalSequenceLength += currentSequenceLength;
					sequenceCount++;
				}
			}
		}
		
		double average = (double) totalSequenceLength / sequenceCount;
		
		return average;
	}
}
