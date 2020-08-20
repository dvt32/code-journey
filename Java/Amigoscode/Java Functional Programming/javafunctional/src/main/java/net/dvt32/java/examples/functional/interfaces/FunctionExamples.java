package net.dvt32.java.examples.functional.interfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExamples {
	
	static int incrementByOne(int number) {
		return number + 1;
	}
	
	static Function<Integer, Integer> incrementByOneFunction = (
		number -> number + 1
	);
	
	static Function<Integer, Integer> multiplyByTenFunction = (
		number -> number * 10
	);
	
	static int incrementByOneAndMultiply(int number, int numberToMultiplyBy) {
		return (number + 1) * numberToMultiplyBy;
	}
	
	static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = 
		(numberToIncrementByOne, numberToMultiplyBy) 
			-> (numberToIncrementByOne + 1) * numberToMultiplyBy;
	
	public static void main(String[] args) {
		/*
		 * java.util.Function examples
		 */
		int increment = incrementByOne(1);
		System.out.println(increment);
		
		int increment2 = incrementByOneFunction.apply(1);
		System.out.println(increment2);
		
		int multiplyByTen = multiplyByTenFunction.apply(increment2);
		System.out.println(multiplyByTen);
		
		Function<Integer, Integer> incrementByOneAndMultiplyByTenFunction = 
			incrementByOneFunction.andThen(multiplyByTenFunction);
		System.out.println( incrementByOneAndMultiplyByTenFunction.apply(4) );
		
		/*
		 * java.util.BiFunction examples
		 */
		System.out.println( incrementByOneAndMultiply(4, 100) );
		
		System.out.println( incrementByOneAndMultiplyBiFunction.apply(4, 100) );
	}
	
}