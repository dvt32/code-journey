// https://community.topcoder.com/stat?c=problem_statement&pm=6677

public class BiggestRectangleEasy {
	public static int findArea(int N) {
		int height = 0;
		int width = 0;
		
		while (N >= 2) {
			height++;
			N -= 2;
			if (N >= 2) {
				width++;
				N -= 2;
			}
		}
		
		int maxArea = height * width;
		
		return maxArea;
	}	
}
