// https://www.hackerrank.com/challenges/phone-book

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		Map<String, Integer> phoneBook = new HashMap<String, Integer>();
		
		int n = read.nextInt();
		read.nextLine();
		
		// Enter people & their phone numbers
		for (int i = 0; i < n; ++i) {
			String name = read.nextLine();
			int phoneNumber = read.nextInt();
			phoneBook.put(name, phoneNumber);
			read.nextLine();
		}
		
		// Search for people and print their names if they're present in the HashMap
		while (read.hasNext()) {
			String personToFind = read.nextLine();
			if (phoneBook.containsKey(personToFind)) {
				System.out.println(personToFind + "=" + phoneBook.get(personToFind));
			}
			else {
				System.out.println("Not found");
			}
		}
		
		// Close scanner
		read.close();
	}
}
