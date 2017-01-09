// https://community.topcoder.com/stat?c=problem_statement&pm=6558

public class EscapeFromRectangle {
	public static int shortest(int x, int y, int w, int h) {
		// distance to reach point 0 on X-coordinate = value of 'x'
		// distance to reach point 0 on Y-coordinate = value of 'y'
		// distance to reach point w on X-coordinate = value of 'w-x'
		// distance to reach point h on Y-coordinate = value of 'h-y'
		// We need the minimum from these distances
		return Math.min(Math.min(x, y), Math.min((w-x), (h-y)));
	}
}
