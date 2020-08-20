package net.dvt32.java.examples.combinator.pattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

	private boolean isValidEmail(String email) {
		return email.contains("@");
	}
	
	private boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.startsWith("+0");
	}
	
	private boolean isAdult(LocalDate dateOfBirth) {
		return Period.between( dateOfBirth, LocalDate.now() ).getYears() > 16;
	}
	
	public boolean isValidCustomer(Customer customer) {
		return 
			isValidEmail( customer.getEmail() ) && 
			isValidPhoneNumber( customer.getPhoneNumber() ) && 
			isAdult( customer.getDateOfBirth() );
	}
	
}