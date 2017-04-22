// https://community.topcoder.com/stat?c=problem_statement&pm=13125

import java.util.LinkedList;
import java.util.Queue;

public class WakingUpEasy {
	public static int countAlarms(int[] volume, int S) {
		Queue<Integer> volumeValues = new LinkedList<Integer>();
		for (int volumeValue : volume) {
			volumeValues.add(volumeValue);
		}
		
		int alarmCount = 0;
		while (S > 0) {
			int firstVolumeValue = volumeValues.peek();
			S -= firstVolumeValue;
			alarmCount++;
			volumeValues.remove();
			volumeValues.add(firstVolumeValue);
		}
		
		return alarmCount;
	}
}
