// Component-Oriented Programming, Practice 2, 21.09.2016 - dvt32

// Quadratic equation

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
	
	static double a, b, c, D, x1, x2;
	static int numberOfSolutions;
	
	static void readQuotients() throws IOException {
		BufferedReader bRead = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("a = "); 
		a = Double.parseDouble(bRead.readLine());
		System.out.print("b = "); 
		b = Double.parseDouble(bRead.readLine());
		System.out.print("c = "); 
		c = Double.parseDouble(bRead.readLine());
	}
	
	static void calculateSolutions() {
		D = b*b - 4*a*c;
		if (D > 0) {
			numberOfSolutions = 2;
			x1 = (-b + Math.sqrt(D)) / (2*a);
			x2 = (-b - Math.sqrt(D)) / (2*a);
		}
		else if (D == 0) {
			numberOfSolutions = 0;
			x1 = -b / (2*a);
		}
		else {
			numberOfSolutions = 0;
		}
	}
	
	static void printOnScreen() {
		switch (numberOfSolutions) {
		case 2:
			System.out.println("x1 = " + x1 + ", x2 = " + x2);
			break;
		case 1:
			System.out.println("x1 = x2 = " + x1);
			break;
		case 0:
			System.out.println("No real solutions.");
			break;
		
		}
	}
	
	public static void main(String[] args) throws IOException {
		readQuotients();
		calculateSolutions();
		printOnScreen();
	}

}
