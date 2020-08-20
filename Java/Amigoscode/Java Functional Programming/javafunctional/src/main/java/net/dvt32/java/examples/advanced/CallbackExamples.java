package net.dvt32.java.examples.advanced;

import java.util.function.Consumer;

public class CallbackExamples {
	
	static void hello(String firstName, String lastName, Consumer<String> callback) {
		System.out.println(firstName);
		
		if (lastName != null) {
			System.out.println(lastName);
		}
		else {
			callback.accept(firstName);
		}
	}
	
	static void helloWithRunnable(String firstName, String lastName, Runnable callback) {
		System.out.println(firstName);
		
		if (lastName != null) {
			System.out.println(lastName);
		}
		else {
			callback.run();
		}
	}
	
	public static void main(String[] args) {
		hello("John", null, value -> {
			System.out.println("No last name provided for " + value);
		});
		
		helloWithRunnable("John", null, () -> {
			System.out.println("No last name provided");
		});
	}
	
}