// dvt

/* 1. Напишете програма, която чете от конзолата три числа от тип int и отпечатва тяхната сума. */


import java.util.Scanner;

public class MyJava {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.print("a = "); int a = read.nextInt(); sum += a;
		System.out.print("b = "); int b = read.nextInt(); sum += b;
		System.out.print("c = "); int c = read.nextInt(); sum += c;
		
		System.out.println("sum = " + sum);
	}

}
