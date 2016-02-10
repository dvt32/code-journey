// dvt

/* 8. 
 Напишете програма, която 
 прилага бонус точки към дадени точки в интервала [1..9] 
 чрез прилагане на следните правила:
- Ако точките са между 1 и 3, програмата ги умножава по 10.
- Ако точките са между 4 и 6, ги умножава по 100.
- Ако точките са между 7 и 9, ги умножава по 1000.
- Ако точките са 0 или повече от 9, се отпечатва съобщение за грешка. */

import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.print("Points = "); int points = read.nextInt();
		
		switch (points){
			case 0: System.out.println("Error!"); return;
			case 1: case 2: case 3: points *= 10; break;
			case 4: case 5: case 6: points *= 100; break;
			case 7: case 8: case 9: points *= 1000; break;
			default: System.out.println("Error!"); return;
		}
		
		System.out.println("New points = " + points);
		
	}

}