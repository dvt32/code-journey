// https://community.topcoder.com/stat?c=problem_statement&pm=4788

public class CheckFunction {
	public int newFunction(String code) {
		int totalDashes = 0;
		for (int i = 0; i < code.length(); ++i) {
			switch (code.charAt(i)) {
			case '0': totalDashes += 6; break;
			case '1': totalDashes += 2; break;
			case '2': totalDashes += 5; break;
			case '3': totalDashes += 5; break;
			case '4': totalDashes += 4; break;
			case '5': totalDashes += 5; break;
			case '6': totalDashes += 6; break;
			case '7': totalDashes += 3; break;
			case '8': totalDashes += 7; break;
			case '9': totalDashes += 6; break;
			default: break;
			}
		}
		return totalDashes;
	}
}
