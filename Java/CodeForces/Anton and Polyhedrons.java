// http://codeforces.com/problemset/problem/785/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		read.nextLine(); // clear buffer
		
		int faceCount = 0;
		for (int i = 0; i < n; ++i) {
			String line = read.nextLine();
			switch (line) {
			case "Tetrahedron": faceCount += 4; break;
			case "Cube": faceCount += 6; break;
			case "Octahedron": faceCount += 8; break;
			case "Dodecahedron": faceCount += 12; break;
			case "Icosahedron": faceCount += 20; break;
			default: break;
			}
		}
		
		System.out.println(faceCount);
		
		// Close scanner
		read.close();
	}
	
}
