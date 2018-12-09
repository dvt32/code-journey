// https://codeforces.com/problemset/problem/984/A

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		LinkedList<Integer> a = new LinkedList<Integer>();
		for (int i = 0; i < n; ++i) {
			a.add(read.nextInt());
		}
		
		Collections.sort(a);
		
		if (n % 2 == 0) {
			while (a.size() > n/2) {
				a.removeLast();
			}
			while (a.size() > 1) {
				a.removeFirst();
			}
		}
		else {
			while (a.size() > 1) {
				a.removeFirst();
				a.removeLast();
			}
		}
		
		System.out.println(a.getFirst());
		
		// Close scanner
		read.close();
	}

}
