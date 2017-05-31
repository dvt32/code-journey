// https://community.topcoder.com/stat?c=problem_statement&pm=5982

// Optimization ideas:
// - average can directly be calculated by evaluating (times[times.length-1] / times.length)
// - no need for an extra array
// Better overall solution: https://github.com/charles-wangkai/topcoder/blob/master/SpeedTyper.java

public class SpeedTyper {
	public static String lettersToPractice(String letters, int[] times) {
		int[] timeToPressKey = new int[times.length];
		timeToPressKey[0] = times[0];
		int sum = times[0];
		
		for (int i = 1; i < times.length; ++i) {
			timeToPressKey[i] = (times[i] - times[i-1]);
			sum += timeToPressKey[i];
		}
		
		double average = (double) sum / times.length;
		StringBuilder lettersToPractise = new StringBuilder();
		
		for (int i = 0; i < timeToPressKey.length; ++i) {
			if (timeToPressKey[i] > average) {
				lettersToPractise.append(letters.charAt(i));
			}
		}
		
		return lettersToPractise.toString();
	}
}
