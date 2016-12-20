// https://community.topcoder.com/stat?c=problem_statement&pm=1728

// Note: Class name should be "ImageDithering" and NOT "DitherCounter", in order to compile on TopCoder Arena

public class ImageDithering {
	public static int count(String dithered, String[] screen) {
		int count = 0;
		
		for (String line : screen) {
			for (int i = 0; i < line.length(); ++i) {
				for (int j = 0; j < dithered.length(); ++j) {
					if (dithered.charAt(j) == line.charAt(i)) {
						count++;
						break;
					}
				}
			}
		}
		
		return count;
	}
}
