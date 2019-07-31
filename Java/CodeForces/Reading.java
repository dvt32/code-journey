// https://codeforces.com/problemset/problem/234/B

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javafx.util.Pair;

public class Solution {

	public static void main(String[] args) 
		throws FileNotFoundException 
	{
		File file = new File("input.txt");
		Scanner read = new Scanner(file);
		
		int n = read.nextInt();
		int k = read.nextInt();

		List< Pair<Integer, Integer> > lightLevels = new ArrayList< Pair<Integer, Integer> >();
		for (int i = 1; i <= n; ++i) {
			lightLevels.add( new Pair<Integer, Integer>(read.nextInt(), i) );
		}
		
		Collections.sort(lightLevels, new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
				if (a.getKey() < b.getKey()) {
					return -1;
				}
				else if (a.getKey() == b.getKey()) {
					return 0;
				}
				else {
					return 1;
				}
	        }
		});
		
		FileOutputStream fileOutputStream = new FileOutputStream(new File("output.txt"));
		boolean appendToFile = true;
		try (PrintWriter output = new PrintWriter(fileOutputStream, appendToFile)) {
			Integer minLightLevel = (Integer) lightLevels.get(n-k).getKey();
			output.println(minLightLevel);
			for (int i = n-k; i < n; ++i) {
				if (k == 0) {
					break;
				}
				output.print( lightLevels.get(i).getValue() + " " );
				k--;
			}
		}
		
		// Close scanner
		read.close();
	}

}
