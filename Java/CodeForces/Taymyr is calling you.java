// https://codeforces.com/problemset/problem/764/A

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		int z = read.nextInt();

		Set<Integer> n_values = new HashSet<>();
		Set<Integer> m_values = new HashSet<>();
		
		for (int n_value = n; n_value <= z; n_value += n) {
			n_values.add(n_value);
		}
		for (int m_value = m; m_value <= z; m_value += m) {
			m_values.add(m_value);
		}
		
		Set<Integer> intersection = new HashSet<>(n_values);
		intersection.retainAll(m_values);
		System.out.println( intersection.size() );

		// Close scanner
		read.close();
	}

}
