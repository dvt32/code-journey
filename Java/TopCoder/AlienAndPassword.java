// https://community.topcoder.com/stat?c=problem_statement&pm=12950

import java.util.Set;
import java.util.HashSet;

public class AlienAndPassword {
	public static int getNumber(String S) {
		if (S.length() == 1) {
			return 1;
		}
		
		Set<String> differentPasswords = new HashSet<String>();
		StringBuilder password = new StringBuilder(S);
		
		for (int i = 0; i < S.length(); ++i) {
			password.deleteCharAt(i);
			differentPasswords.add(password.toString());
			password = new StringBuilder(S);
		}
		
		return differentPasswords.size();
	}
}
