// https://community.topcoder.com/stat?c=problem_statement&pm=10616

public class TheBlackJackDivTwo {
	public static int score(String[] cards) {
		int score = 0;
		
		for (String card : cards) {
			switch (card.charAt(0)) {
			case '2': score += 2; break;
			case '3': score += 3; break;
			case '4': score += 4; break;
			case '5': score += 5; break;
			case '6': score += 6; break;
			case '7': score += 7; break;
			case '8': score += 8; break;
			case '9': score += 9; break;
			case 'T':
			case 'J':
			case 'Q':
			case 'K': score += 10; break;
			case 'A': score += 11; break;
			default: break;
			}
		}
		
		return score;
	}
}
