package net.dvt32.regexandvalidation.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;

/**
 * This program extracts a Bulgarian IBAN number between <iban></iban> tags,
 * validates it and if the number is valid, censors its first part (first 20 digits)
 * with "****".
 * 
 * The validation is done with the external library Apache Commons Validator.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class IbanValidator {
	/**
	 * This method accomplishes the program's main task (described above) and returns a censored String.
	 * 
	 * @param str The input string, containing IBAN numbers between tags
	 * @return the input string with censored valid Bulgarian IBAN numbers
	 */
	public String getStringWithCensoredIbanFirstPart(String str) {
		Matcher m = Pattern.compile(
			// Starts with BG and has <iban> before it (positive lookahead)
			"(?<=<iban>)BG"
			// Has any number of letters, digits or white spaces after it
			+ "[a-z0-9 ]*"
			// ... and that sequence has </iban>> after it (positive lookbehind)
			+ "(?=<\\/iban>)",
			// The whole pattern is case-insensitive (IBAN numbers can be validated in lowercase too)
			Pattern.CASE_INSENSITIVE
		).matcher(str);
		
		while ( m.find() ) {
			String textBetweenIbanTags = m.group();
			String ibanNumber = textBetweenIbanTags.substring(0, textBetweenIbanTags.length()-2).replaceAll(" ", "");
			String ibanSegmentToCensor = textBetweenIbanTags.substring(0, textBetweenIbanTags.length()-4);
			IBANCheckDigit ibanChecker = new IBANCheckDigit();
			if ( ibanChecker.isValid(ibanNumber) ) {
				str = str.replace(ibanSegmentToCensor, "****");
			}
		}
		
		return str;
	}
}