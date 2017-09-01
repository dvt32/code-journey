package net.dvt32.regexandvalidation.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This program validates e-mail addresses via regular expressions.
 * 
 * According to the task description, a valid email:
 * - starts with a latin letter
 * - is followed by a series of latin letters, digits, '.' or '-'
 * - is followed by a '@'
 * - is followed by another latin letter
 * - ends with another series of latin letters, digits, '.' or '-'
 * 
 * The class uses the Pattern and Matcher classes internally.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class EmailValidator {
	private static final Pattern VALID_EMAIL_REGEX_PATTERN = 
	    Pattern.compile(
	    	// 1. Starts with a latin letter
	    	"^[A-Z]" 
	    	// 2. Is followed by a series of latin letters, digits, '.' or '-'
	    	+ "[A-Z0-9.-]+" 
	    	// 3. Is followed by a '@'
	    	+ "@"
	    	// 4. Is followed by another latin letter
	    	+ "[A-Z]"
	    	// 5. Ends with another series of latin letters, digits, '.' or '-'
	    	+ "[A-Z0-9.-]+$", 
	    	// The whole regular expression is case insensitive
	    	Pattern.CASE_INSENSITIVE
	    );

	/**
	 * This method validates a certain email address,
	 * based on the regular expression pattern above.
	 * 
	 * @param email The address being validated
	 * @return true if the email is valid, false otherwise
	 */
	public static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_REGEX_PATTERN.matcher(email);
        boolean isValidEmail = matcher.find();
        return isValidEmail;
	}
}