// dvt

/* 5. Напишете програма, която 
 * при въвеждане на коефициентите (a, b и c) 
 * на квадратно уравнение
   изчислява и извежда неговите реални корени. */

import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		double a, b, c, D, x1 = 0.0, x2 = 0.0;
		
		System.out.print("a = "); a = read.nextInt();
		System.out.print("b = "); b = read.nextInt();
		System.out.print("c = "); c = read.nextInt();
		
		// Calculations
		D = Math.pow(b, 2) - (4*a*c);
		
		if (D<0) { return; }
		if (D>0){
			x1 = (-b + Math.sqrt(D)) / (2*a);
			x2 = (-b - Math.sqrt(D)) / (2*a);	
		}
		if (D == 0){
			x1 = -b / (2*a);
			x2 = x1;		
		}
		
		// Display on screen
		System.out.println("\nD = " + (int)D);
		System.out.println("x1 = " + (int)x1);
		System.out.println("x2 = " + (int)x2);

	}

}
