package net.dvt32.java.examples.advanced;

import java.util.function.BiFunction;

public class LambdaExamples {
	
	public static void main(String[] args) {
		BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
			if (name.isEmpty()) {
				throw new IllegalArgumentException("");
			}
			
			System.out.println(age);
			
			return name.toUpperCase();
		};
		
		String upperCasedName = upperCaseName.apply("Alex", 20);
		System.out.println(upperCasedName);
	}
	
}