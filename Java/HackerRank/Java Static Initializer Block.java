// https://www.hackerrank.com/challenges/java-static-initializer-block

import java.util.Scanner;

public class Solution {
	
	static Scanner read = new Scanner(System.in);
	static int B;
	static int H;
	static boolean flag;
	
	static {
		B = read.nextInt();
		H = read.nextInt();
		flag = (B > 0 && B <= 100 && H > 0 && H <= 100);
		if (!flag) {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
		}
		read.close();
	}
	
	public static void main(String[] args){
		if (flag) {
			int area = B*H;
			System.out.println(area);
		}
	}
}
