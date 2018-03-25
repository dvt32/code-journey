// http://codeforces.com/problemset/problem/237/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		Map<String, Integer> customersAtTime = new HashMap<String, Integer>();
		SortedSet<Integer> frequencies = new TreeSet<Integer>();
		for (int i = 0; i < n; ++i) {
			int h = read.nextInt();
			int m = read.nextInt();
			
			Integer customerCount = customersAtTime.get( h + ":" + m );
			if (customerCount != null) {
				customersAtTime.put( h + ":" + m, customerCount+1 );
			}
			else {
				customersAtTime.put( h + ":" + m, 1 );
			}
			
			frequencies.add( customersAtTime.get( h + ":" + m ) );
		}
		
		int cashCount = frequencies.last();
		System.out.println(cashCount);
		
		// Close scanner
		read.close();
	}
	
}
