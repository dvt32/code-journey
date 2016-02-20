// dvt32

/* 
 * 1. Да се напише програма, която 
 * създава масив с 20 елемента от целочислен тип 
 * и инициализира всеки от елементите със стойност 
 * равна на индекса на елемента умножен по 5. 
 * 
 * Елементите на масива да се изведат на конзолата.
 */

import java.util.Arrays;

public class myClass {
	public static void main(String[] args) {
		
		int[] myArr = new int[20];
		for (int i = 0; i < myArr.length; ++i){
			myArr[i] = i * 5;
		}
		System.out.println(Arrays.toString(myArr));
	}
}
