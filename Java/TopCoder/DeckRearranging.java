// https://community.topcoder.com/stat?c=problem_statement&pm=9914

public class DeckRearranging {
	public static String rearrange(String deck, int[] above) {
		StringBuilder newDeck = new StringBuilder();
		
		for (int i = 0; i < deck.length(); ++i) {
			newDeck.insert(above[i], deck.charAt(i));
		}
		
		return newDeck.toString();
	}
}
