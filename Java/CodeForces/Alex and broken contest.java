// http://codeforces.com/problemset/problem/877/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		String line = read.nextLine();
		
		Set<String> friendNames = new HashSet<String>();
		friendNames.add("Danil");
		friendNames.add("Olya");
		friendNames.add("Slava");
		friendNames.add("Ann");
		friendNames.add("Nikita");
		
		int numberOfFriendNamesFound = 0;
		for (String friendName : friendNames) {
			Pattern p = Pattern.compile(friendName);
			Matcher m = p.matcher(line);
			while (numberOfFriendNamesFound < 2 && m.find()) {
				numberOfFriendNamesFound++;
			}
			if (numberOfFriendNamesFound == 2) {
				break;
			}
		}
		
		if (numberOfFriendNamesFound == 1) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
}
