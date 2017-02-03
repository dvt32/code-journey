// https://community.topcoder.com/stat?c=problem_statement&pm=12990

public class BoundingBox {
	public static int smallestArea(int[] X, int[] Y) {
		int xMax = X[0];
		int xMin = X[0];
		int yMin = Y[0];
		int yMax = Y[0];
		
		for (int i = 1; i < X.length; ++i) {
			if (X[i] > xMax) {
				xMax = X[i];
			}
			if (X[i] < xMin) {
				xMin = X[i];
			}
			if (Y[i] > yMax) {
				yMax = Y[i];
			}
			if (Y[i] < yMin) {
				yMin = Y[i];
			}
		}
		
		int width = Math.abs(xMax - xMin);
		int height = Math.abs(yMax - yMin);

		int area = width * height;
		
		return area;
	}
}
