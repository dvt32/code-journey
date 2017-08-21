package net.dvt32.regexandvalidation.task5;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmailValidatorTest {

	EmailValidator ev = new EmailValidator();
	
	@Test
	public void shouldConsiderAllEmailsValid() {
		String[] emails = new String[] {
			"test.t-s@m-sol.com",
			"h1ello@msol9999.com",
			"test@msol.com",
			"eee@m-msol.com",
			"eee@cc.british.museum"
		};
		
		for (String email : emails) {
			assertTrue( ev.isValidEmail(email) );
		}
	}
	
	@Test
	public void shouldConsiderAllEmailsInvalid() {
		String[] emails = new String[] {
			"q@m-sol.com", // only one letter in first part
			"h1ello,@msol9999.com", // first part contains ','
			"test@msol. com", // second part contains space
			"", // empty email
			"@test.com", // no first part
			"qq@a" // second part incomplete
		};
		
		for (String email : emails) {
			assertTrue( !ev.isValidEmail(email) );
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() {
		ev.isValidEmail(null);
	}

}