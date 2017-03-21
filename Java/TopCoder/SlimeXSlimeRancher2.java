// https://community.topcoder.com/stat?c=problem_statement&pm=11279

public class SlimeXSlimeRancher2 {
	public static int train(int[] attributes) {
		// Get max attribute value
		int maxAttribute = 0;
		for (int attribute : attributes) {
			if (attribute > maxAttribute) {
				maxAttribute = attribute;
			}
		}
		
		// Get min weight, based on max attribute value
		int minWeight = 0;
		for (int i = 0; i < attributes.length; ++i) {
			minWeight += Math.abs( maxAttribute - attributes[i] );
		}
		
		return minWeight;
	}
}
