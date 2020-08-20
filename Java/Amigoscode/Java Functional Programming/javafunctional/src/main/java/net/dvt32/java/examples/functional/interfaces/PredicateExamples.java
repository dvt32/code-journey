package net.dvt32.java.examples.functional.interfaces;

import java.util.function.Predicate;

public class PredicateExamples {
	
	static boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
	}
	
	static Predicate<String> isValidPhoneNumberPredicate = phoneNumber ->
	 	phoneNumber.startsWith("07") && phoneNumber.length() == 11;
	 	
	static Predicate<String> containsNumberThree = phoneNumber ->
		phoneNumber.contains("3");
	
	public static void main(String[] args) {
		System.out.println("Without predicate: ");
		System.out.println( isValidPhoneNumber("07000000000") );
		System.out.println( isValidPhoneNumber("0700000000") );
		System.out.println( isValidPhoneNumber("09009877300") );
		
		System.out.println("With predicate: ");
		System.out.println( isValidPhoneNumberPredicate.test("07000000000") );
		System.out.println( isValidPhoneNumberPredicate.test("0700000000") );
		System.out.println( isValidPhoneNumberPredicate.test("09009877300") );
		
		System.out.println("Is valid AND contains three: ");
		System.out.println( 
			isValidPhoneNumberPredicate.and(containsNumberThree).test("09009877300")
		);
		System.out.println( 
			isValidPhoneNumberPredicate.and(containsNumberThree).test("07000000003")
		);
		
		System.out.println("Is valid OR contains three: ");
		System.out.println( 
			isValidPhoneNumberPredicate.or(containsNumberThree).test("09009877300")
		);
		System.out.println( 
			isValidPhoneNumberPredicate.or(containsNumberThree).test("07000000003")
		);
	}
	
}