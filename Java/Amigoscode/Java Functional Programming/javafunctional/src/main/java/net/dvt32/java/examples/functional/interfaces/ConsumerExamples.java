package net.dvt32.java.examples.functional.interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExamples {
	
	static class Customer {
		private final String name;
		private final String phoneNumber;
		
		public Customer(String name, String phoneNumber) {
			super();
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
	}
	
	static void greetCustomer(Customer customer) {
		System.out.println(
			"Hello, " + customer.name + 
			"! Thanks for registering the phone number " + customer.phoneNumber
			+ "!"
		);
	}
	
	static void greetCustomer(Customer customer, boolean showPhoneNumber) {
		System.out.println(
			"Hello, " + customer.name + 
			"! Thanks for registering the phone number " + (showPhoneNumber ? customer.phoneNumber : "*****")
			+ "!"
		);
	}
	
	static Consumer<Customer> greetCustomerConsumer = customer ->
		System.out.println(
			"Hello, " + customer.name + 
			"! Thanks for registering the phone number " + customer.phoneNumber
			+ "!"
		);
		
	static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
		System.out.println(
			"Hello, " + customer.name + 
			"! Thanks for registering the phone number " + (showPhoneNumber ? customer.phoneNumber : "*****")
			+ "!"
		);
	
	public static void main(String[] args) {
		Customer maria = new Customer("Maria", "99999");
		
		greetCustomer(maria);
		greetCustomer(maria, true);
		greetCustomer(maria, false);
		
		greetCustomerConsumer.accept(maria);
		greetCustomerBiConsumer.accept(maria, true);
		greetCustomerBiConsumer.accept(maria, false);
	}
	
}