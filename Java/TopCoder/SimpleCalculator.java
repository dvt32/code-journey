// https://community.topcoder.com/stat?c=problem_statement&pm=2272

public class SimpleCalculator {
	public static int calculate(String input) {
		// Get operator
		char operator = '?';
		int i = 0;
		while (true) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' ||input.charAt(i) == '/') {
				operator = input.charAt(i);
				break;
			}
			i++;
		}
		
		// Calculate expression
		int result = 0;
		switch (operator) {
		case '+':
			return (Integer.parseInt(input.substring(0, i)) + Integer.parseInt(input.substring(i+1)));
		case '-':
			return (Integer.parseInt(input.substring(0, i)) - Integer.parseInt(input.substring(i+1)));
		case '*':
			return (Integer.parseInt(input.substring(0, i)) * Integer.parseInt(input.substring(i+1)));
		case '/':
			return (Integer.parseInt(input.substring(0, i)) / Integer.parseInt(input.substring(i+1)));
		default:
			break;
		}
		
		return result;
	}
}
