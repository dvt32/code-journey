// https://community.topcoder.com/stat?c=problem_statement&pm=2924

public class MovingAverages {
	public static int[] calculate(String[] times, int n) {
		int[] movingAverages = new int[times.length - n + 1];
		
		// Calculate average of elements ranging from times[startIndex] to times[endIndex]
		int i = 0;
		for (int startIndex = 0, endIndex = n-1; 
			 endIndex < times.length; 
			 ++startIndex, ++endIndex) 
		{
			int sumOfTime = 0;	// sum of time in current range
			int timeCount = 0;	// number of elements in current range
			for (int j = startIndex; j <= endIndex; ++j) {
				int timeInSeconds =
						( Integer.parseInt(times[j].substring(0, 2)) * 3600 ) + // hours (in seconds)
						( Integer.parseInt(times[j].substring(3, 5)) * 60 ) +	// minutes (in seconds)
						( Integer.parseInt(times[j].substring(6, 8)) );			// seconds
				sumOfTime += timeInSeconds;
				timeCount++;
			}
			movingAverages[i] = (sumOfTime / timeCount);
			i++;
		}
	
		return movingAverages;
	}
}
