// https://community.topcoder.com/stat?c=problem_statement&pm=11936

public class WorkingRabbits {
	public static double getEfficiency(String[] profit) {
		int P = 0;
		int rowStartIndex = 1; // we only need the elements after the main diagonal
		
		for (int i = 0; i < profit.length; ++i) {
			for (int j = rowStartIndex; j < profit[i].length(); ++j) {
				P += Character.getNumericValue(profit[i].charAt(j));
			}
			rowStartIndex++;
		}
		
		/*
		 * The number of unique pairs can be calculated via a formula, which is explained here:
		 * - http://stackoverflow.com/questions/18859430/how-do-i-get-the-total-number-of-unique-pairs-of-a-set-in-the-database
		 */
		 int Q = (profit.length) * (profit.length - 1) / 2; 
		
		 double efficiency = (double) P / Q;
		 
		 return efficiency;
	}
}
