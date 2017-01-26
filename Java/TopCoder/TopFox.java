// https://community.topcoder.com/stat?c=problem_statement&pm=12643

import java.util.Set;
import java.util.HashSet;

public class TopFox {
	public static int possibleHandles(String familyName, String givenName) {
		Set<String> handles = new HashSet<String>();
		
		for (int i = 0; i < familyName.length(); ++i) {
			for (int j = 0; j < givenName.length(); ++j) {
				String handleName = familyName.substring(0, i+1) + givenName.substring(0, j+1);
				handles.add(handleName);
			}
		}
		
		return handles.size();
	}
}
