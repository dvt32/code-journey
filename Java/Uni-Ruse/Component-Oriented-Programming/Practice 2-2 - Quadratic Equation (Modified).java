// Component-Oriented Programming, Practice 2, 21.09.2016 - dvt32

// Quadratic equation (modified)

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// Class is accessible in Solution, because they're in the same package
class QuadraticEquation {
	double a, b, c, x1, x2;
	int numberOfSolutions;
}

public class Solution {
	
	static QuadraticEquation equation = new QuadraticEquation();
	
	static void readQuotients() throws IOException {
		BufferedReader bRead = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("a = "); 
		equation.a = Double.parseDouble(bRead.readLine());
		System.out.print("b = "); 
		equation.b = Double.parseDouble(bRead.readLine());
		System.out.print("c = "); 
		equation.c = Double.parseDouble(bRead.readLine());
	}
	
	static void calculateSolutions() {
		double D = equation.b*equation.b - 4*equation.a*equation.c;
		if (D > 0) {
			equation.numberOfSolutions = 2;
			equation.x1 = (-equation.b + Math.sqrt(D)) / (2*equation.a);
			equation.x2 = (-equation.b - Math.sqrt(D)) / (2*equation.a);
		}
		else if (D == 0) {
			equation.numberOfSolutions = 0;
			equation.x1 = -equation.b / (2*equation.a);
		}
		else {
			equation.numberOfSolutions = 0;
		}
	}
	
	static void printOnScreen() {
		switch (equation.numberOfSolutions) {
		case 2:
			System.out.println("x1 = " + equation.x1 + ", x2 = " + equation.x2);
			break;
		case 1:
			System.out.println("x1 = x2 = " + equation.x1);
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
