// dvt32

/* 3. Да се напише програма, която 
 * сравнява два масива от тип char 
 * лексикографски (буква по буква) 
 * и проверява кой от двата е по-рано в лексикографската подредба. 
 * */

import java.util.Scanner;
import java.util.Arrays;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String winner = "";
		int shorterLength = 0;
		
		char[] charArr_A;
		char[] charArr_B;;
		
		System.out.print("charArr_A = "); charArr_A = read.next().toCharArray();
		System.out.print("charArr_B = "); charArr_B = read.next().toCharArray();
		
		int aLength = charArr_A.length;
		int bLength = charArr_B.length;
		
		if (aLength > bLength) { shorterLength = bLength; }
		if (aLength < bLength) { shorterLength = aLength; }
		if (aLength == bLength) { shorterLength = bLength; }
		
		for (int i = 0; i < shorterLength; ++i){
			if (charArr_A[i] > charArr_B[i]) { winner = "A wins!"; break; }
			if (charArr_B[i] > charArr_A[i]) { winner = "B wins!"; break; }
			if (Arrays.equals(charArr_A, charArr_B)) { winner = "They're equal."; break; }
			if (charArr_A.length != shorterLength && i == shorterLength-1) 
			{ winner = "B wins!"; break; } else { winner = "A wins!"; break; }
		}
		
		System.out.println(winner);
		
		
		
	}

}
