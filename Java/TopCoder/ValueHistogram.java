// https://community.topcoder.com/stat?c=problem_statement&pm=12275

import java.util.Map;
import java.util.HashMap;

public class ValueHistogram {
	public static String[] build(int[] values) {
		// Get frequency of each character & max frequency
		Map<Integer, Integer> valueFrequencies = new HashMap<Integer, Integer>();
		int maxFrequencies = 0;
		
		for (int value : values) {
			int frequencyCount = valueFrequencies.containsKey(value) ? valueFrequencies.get(value) : 0;
			valueFrequencies.put(value, frequencyCount + 1);
			
			if (valueFrequencies.get(value) > maxFrequencies) {
				maxFrequencies = valueFrequencies.get(value);
			}
		}
		
		// Generate histogram
		final int HISTOGRAM_WIDTH = 10; // number of columns (number of characters on each row)
		final int HISTOGRAM_HEIGHT = maxFrequencies + 1; // number of rows
		char[][] histogramMatrix = new char[HISTOGRAM_HEIGHT][HISTOGRAM_WIDTH];
		
		for (int colIndex = 0; colIndex < HISTOGRAM_WIDTH; ++colIndex) {
			int currentFrequencies = valueFrequencies.containsKey(colIndex) ? valueFrequencies.get(colIndex) : 0;
			
			for (int rowIndex = HISTOGRAM_HEIGHT - 1; rowIndex >= 0; --rowIndex) {
				if (currentFrequencies > 0) {
					histogramMatrix[rowIndex][colIndex] = 'X';
					currentFrequencies--;
				}
				else {
					histogramMatrix[rowIndex][colIndex] = '.';
				}
			}
		}
		
		// Convert 2D char array to String array
		String[] histogram = new String[HISTOGRAM_HEIGHT];
		for (int i = 0; i < histogram.length; ++i) {
			histogram[i] = new String(histogramMatrix[i]);
		}
 		
		return histogram;
	}
}
