// dvt32

/* 4.    Напишете метод, който намира колко пъти дадено число се среща в даден масив. 
 * 
 * Напишете програма, която проверява дали този метод работи правилно. */

package myJava;

import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);	
		
		double[] myArr = new double[5];
		
		for (int i = 0; i < myArr.length; ++i){
			System.out.print("myArr["+i+"]: "); myArr[i] = read.nextDouble();
		}
		
		System.out.println("\nEnter number: "); double number = read.nextDouble();
		
		int numberOfInstances = getArrayInstancesOfNumber(number, myArr);
		
		System.out.println("Instances: " + numberOfInstances);
		
		
	}
	
	// get instances of number in array
	public static int getArrayInstancesOfNumber(double number, double[] arr){
		int numberOfTimes = 0;
		
		for (int i = 0; i < arr.length; ++i){
			if (arr[i] == number) {
				numberOfTimes++;
			}
		}
		
		return numberOfTimes;
	}

}
