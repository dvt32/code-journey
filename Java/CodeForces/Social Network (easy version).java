// https://codeforces.com/problemset/problem/1234/B1

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		int[] id = new int[n];
		for (int i = 0; i < n; ++i) {
			id[i] = read.nextInt();
		}
		
		LinkedList<Integer> elementsOnScreen = new LinkedList<>();
		elementsOnScreen.add( id[0] );

		for (int i = 1; i < n; ++i) {
			if (elementsOnScreen.contains(id[i])) {
				continue;
			}
			
			if (elementsOnScreen.size() == k) {
				elementsOnScreen.removeLast();
			}
			
			elementsOnScreen.addFirst(id[i]);
		}
		
		System.out.println(elementsOnScreen.size());
		for (Integer element : elementsOnScreen) {
			System.out.print(element + " ");
		}
		
		// Close scanner
		read.close();
	}

}
