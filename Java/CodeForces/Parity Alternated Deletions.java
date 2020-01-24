// https://codeforces.com/problemset/problem/1144/B

// https://codeforces.com/blog/entry/66307

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		List<Integer> oddNumbers = new ArrayList<>();
		List<Integer> evenNumbers = new ArrayList<>();
		int sum = 0;
		
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			if (a % 2 != 0) { oddNumbers.add(a); }
			else { evenNumbers.add(a); }
			sum += a;
		}
		
		Collections.sort( oddNumbers, Collections.reverseOrder() );
		Collections.sort( evenNumbers, Collections.reverseOrder() );
		
		int k = Math.min(oddNumbers.size(), evenNumbers.size());
		for (int i = 0; i < k; ++i) {
			sum -= oddNumbers.get(i);
			sum -= evenNumbers.get(i);
		}
		
		if (oddNumbers.size() != evenNumbers.size()) {
			sum -= 
				(oddNumbers.size() > evenNumbers.size()) 
				? oddNumbers.get(k) 
				: evenNumbers.get(k);
		}
		
		System.out.println(sum);
		
		// Close scanner
		read.close();
	}

}
