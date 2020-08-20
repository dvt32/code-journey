package net.dvt32.java.examples.combinator.pattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import net.dvt32.java.examples.combinator.pattern.CustomerRegistrationValidator.ValidationResult;

public interface CustomerRegistrationValidator
	extends Function<Customer, ValidationResult>
{
	enum ValidationResult {
		SUCCESS,
		PHONE_NUMBER_NOT_VALID,
		EMAIL_NOT_VALID,
		IS_NOT_ADULT
	}
	
	static CustomerRegistrationValidator isValidEmail() {
		return (
			customer -> 
				customer.getEmail().contains("@") 
				? ValidationResult.SUCCESS
				: ValidationResult.EMAIL_NOT_VALID
		);
	}
	
	static CustomerRegistrationValidator isValidPhoneNumber() {
		return (
			customer -> 
				customer.getPhoneNumber().startsWith("+0")
				? ValidationResult.SUCCESS
				: ValidationResult.PHONE_NUMBER_NOT_VALID
		);
	}
	
	static CustomerRegistrationValidator isAdult() {
		return (
			customer -> 
				Period.between( customer.getDateOfBirth(), LocalDate.now() ).getYears() > 16
				? ValidationResult.SUCCESS
				: ValidationResult.IS_NOT_ADULT
		);
	}
	
	default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return (
				result.equals(ValidationResult.SUCCESS) 
				? other.apply(customer) 
				: result
			);
		};
	}
	
}