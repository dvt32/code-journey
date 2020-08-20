package net.dvt32.java.examples.combinator.pattern;

import static net.dvt32.java.examples.combinator.pattern.CustomerRegistrationValidator.*;

import java.time.LocalDate;

public class CombinatorPatternExamples {
	
	public static void main(String[] args) {
		Customer customer = new Customer(
			"alice", "alice@gmail.com", "+0878787878", LocalDate.of(2000, 1, 1)
		);
		
		/*
		CustomerValidatorService validatorService = new CustomerValidatorService();
		boolean isValidCustomer = validatorService.isValidCustomer(customer);
		System.out.println(isValidCustomer);
		*/
		
		/*
		 *  Using the Combinator pattern
		 */
		ValidationResult result = isValidEmail()
			.and( isValidPhoneNumber() )
			.and( isAdult() )
			.apply(customer);
		
		System.out.println(result);
		
		if (result != ValidationResult.SUCCESS) {
			throw new IllegalStateException( result.name() );
		}
	}
	
}