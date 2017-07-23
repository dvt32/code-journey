package net.dvt32.introtasks.task7;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordGeneratorTest {
	
	PasswordGenerator pg = new PasswordGenerator();

	@Test
	public void shouldGenerateFiveLetterPasswordWithOnlyLettersAndDigits() {
		String password = pg.generateStringPassword(5);
		boolean isValidPassword = true;
		
		for (int i = 0; i < password.length(); ++i) {
			boolean charIsLetter = Character.isLetter( password.charAt(i) );
			boolean charIsDigit = Character.isDigit( password.charAt(i) );
			
			if (!charIsLetter && !charIsDigit) {
				isValidPassword = false;
				break;
			}
		}
		
		assertTrue( (password.length() == 5) && (isValidPassword) );
	}
	
	@Test
	public void shouldGenerateBlankPassword() {
		String password = pg.generateStringPassword(-1);
		assertTrue( password.isEmpty() );
	}
}
