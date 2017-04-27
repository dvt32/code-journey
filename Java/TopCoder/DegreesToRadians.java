// https://community.topcoder.com/stat?c=problem_statement&pm=7410

public class DegreesToRadians {
	public static double convertToRadians(int degrees, int minutes, int seconds) {
		double minutesInDegrees = (double) minutes / 60;
		double secondsInDegrees = (double) seconds / 3600;
		
		double totalDegrees = 
			degrees +
			minutesInDegrees +
			secondsInDegrees;
		
		double radians = totalDegrees * Math.PI / 180;
		
		return radians;
	}
}
