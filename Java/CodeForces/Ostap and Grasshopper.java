// http://codeforces.com/problemset/problem/735/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		read.nextLine();
		
		String line = read.nextLine();
		
		int grasshopperIndex = line.indexOf("G");
		int targetIndex = line.indexOf("T");
		
		boolean targetDestroyed = false;
		if (grasshopperIndex < targetIndex) { // move grasshopper to the RIGHT
			for (int i = grasshopperIndex; i < line.length(); i += k) {
				char c = line.charAt(i);
				if (c == '#') {
					break;
				}
				else if (c == 'T') {
					targetDestroyed = true;
					break;
				}
			}
		}
		else { // move grasshopper to the LEFT
			for (int i = grasshopperIndex; i >= 0; i -= k) {
				char c = line.charAt(i);
				if (c == '#') {
					break;
				}
				else if (c == 'T') {
					targetDestroyed = true;
					break;
				}
			}
		}
		
		if (targetDestroyed) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
