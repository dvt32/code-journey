// https://community.topcoder.com/stat?c=problem_statement&pm=6109

public class ThreeCardMonte {
	public static String position(String swaps) {
		char[] cards = { 'J', 'A', 'J' };
		
		for (int i = 0; i < swaps.length(); ++i) {
			char temp;
			switch (swaps.charAt(i)) {
			case 'L':
				temp = cards[0];
				cards[0] = cards[1];
				cards[1] = temp;
				break;
			case 'R':
				temp = cards[1];
				cards[1] = cards[2];
				cards[2] = temp;
				break;
			case 'E':
				temp = cards[0];
				cards[0] = cards[2];
				cards[2] = temp;
				break;
			case 'F':
				break;
			default:
				break;
			}
		}
		
		char acePosition;
		
		if (cards[0] == 'A') { 
			acePosition = 'L'; 
			}
		else if (cards[2] == 'A') { 
			acePosition = 'R'; 
		}
		else { 
			acePosition = 'M'; 
		}
		
		return String.valueOf(acePosition);
	}
}
