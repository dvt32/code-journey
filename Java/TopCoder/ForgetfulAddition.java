// https://community.topcoder.com/stat?c=problem_statement&pm=13553

public class ForgetfulAddition {
	public static int minNumber(String expression) {
		int minResult = Integer.MAX_VALUE;
		
		int secondOperandStartIndex = 1;
		for (int i = 0; i < expression.length()-1; ++i) {
			int expressionResult = 
				Integer.parseInt( expression.substring(0, secondOperandStartIndex) ) +
				Integer.parseInt( expression.substring(secondOperandStartIndex) );
			if (expressionResult < minResult) {
				minResult = expressionResult;
			}
			secondOperandStartIndex++;
		}
		
		return minResult;
	}
}
