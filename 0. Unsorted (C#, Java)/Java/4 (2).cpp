// dvt

/* 4. Напишете програма, която 
 * отпечатва всички възможни карти 
 * от стандартно тесте без джокери 
 * (имаме 52 карти: 4 бои по 13 карти). */

import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		// 2,3,4,5,6,7,8,9,10,J,Q,K,A
		// 1 - спатия, 2 – каро, 3 – купа, 4 – пика
		
		String[] card = 
		{ 
			"0", "0",
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
		};
		
		
		for (int i = 2; i <= 14; ++i){
			for (int j = 1; j <= 4; ++j){
				System.out.print(card[i]);
				if (j == 1) { System.out.println(" спатия"); }
				if (j == 2) { System.out.println(" каро"); }
				if (j == 3) { System.out.println(" купа"); }
				if (j == 4) { System.out.println(" пика\n"); }
			}
		}
		
	}

}