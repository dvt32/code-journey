// https://codeforces.com/problemset/problem/387/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		String t = read.nextLine();
		
		String[] currentTime = s.split(":");
		String[] sleepTime = t.split(":");
		
		int currentTimeInMinutes = Integer.parseInt(currentTime[0]) * 60 + Integer.parseInt(currentTime[1]);
		int timeSleptInMinutes = Integer.parseInt(sleepTime[0]) * 60 + Integer.parseInt(sleepTime[1]);
		
		int timeWentToBedInMinutes = 0;
		if (currentTimeInMinutes > timeSleptInMinutes) {
			timeWentToBedInMinutes = currentTimeInMinutes - timeSleptInMinutes;
		}
		else {
			timeSleptInMinutes -= currentTimeInMinutes;
			int midnightInMinutes = 24 * 60;
			timeWentToBedInMinutes = midnightInMinutes - timeSleptInMinutes;
		}
		
		int hours = timeWentToBedInMinutes / 60;
		int minutes = timeWentToBedInMinutes - (hours * 60);
		if (hours == 24) { hours = 0; }
		
		String p = 
			(hours > 9 ? String.valueOf(hours) : "0"+hours) + 
			":" + 
			(minutes > 9 ? String.valueOf(minutes) : "0"+minutes);
		
		System.out.println(p);
		
		// Close scanner
		read.close();
	}

}
