package net.dvt32.regexandvalidation.task6;

import static org.junit.Assert.*;

import org.junit.Test;

public class IbanValidatorTest {
	
	IbanValidator iv = new IbanValidator();
	private final String EXAMPLE_INPUT = 
		"<bankAccounts>\r\n" + 
		"<iban>GR16 0110 1050 0000 1054 7023 795</iban>\r\n" + 
		"<iban>GB35 MIBG 4025 3432 1446 70</iban>\r\n" + 
		"<iban>SA80 8000 0375 6080 1019 0160</iban>\r\n" + 
		"<iban>CH51 0868 6001 2565 1500 1</iban>\r\n" + 
		"<iban>BG80 BNBG 9661 1020 3456 7840</iban>\r\n" + 
		"<iban>IL30 01BG 0300 0009 6339 234</iban>\r\n" + 
		"<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\r\n" + 
		"<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\r\n" + 
		"<iban>BG80 BNBG 9661 1020 3456 7843</iban>\r\n" + 
		"</bankAccounts>\r\n";
	
	@Test
	public void shouldCensorTwoBulgarianIbanNumbers() {
		String expectedResult =
			"<bankAccounts>\r\n" + 
			"<iban>GR16 0110 1050 0000 1054 7023 795</iban>\r\n" + 
			"<iban>GB35 MIBG 4025 3432 1446 70</iban>\r\n" + 
			"<iban>SA80 8000 0375 6080 1019 0160</iban>\r\n" + 
			"<iban>CH51 0868 6001 2565 1500 1</iban>\r\n" + 
			"<iban>****7840</iban>\r\n" + 
			"<iban>IL30 01BG 0300 0009 6339 234</iban>\r\n" + 
			"<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\r\n" + 
			"<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\r\n" + 
			"<iban>****7843</iban>\r\n" + 
			"</bankAccounts>\r\n";
		String actualResult = iv.getStringWithCensoredIbanFirstPart(EXAMPLE_INPUT);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() {
		iv.getStringWithCensoredIbanFirstPart(null);
	}
	
	@Test
	public void shouldNotCensorAnything() {
		String input =
			"<bankAccounts>\r\n" + 
			"<iban>GR16 0110 1050 0000 1054 7023 795</iban>\r\n" + 
			"<iban>GB35 MIBG 4025 3432 1446 70</iban>\r\n" + 
			"<iban>SA80 8000 0375 6080 1019 0160</iban>\r\n" + 
			"<iban>CH51 0868 6001 2565 1500 1</iban>\r\n" + 
			"<iban>****7840</iban>\r\n" + 
			"<iban>IL30 01BG 0300 0009 6339 234</iban>\r\n" + 
			"<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\r\n" + 
			"<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\r\n" + 
			"<iban>****7843</iban>\r\n" + 
			"</bankAccounts>\r\n";
		
		String expectedResult = input;
		String actualResult = iv.getStringWithCensoredIbanFirstPart(input);
		assertEquals(expectedResult, actualResult);
	}
	
}