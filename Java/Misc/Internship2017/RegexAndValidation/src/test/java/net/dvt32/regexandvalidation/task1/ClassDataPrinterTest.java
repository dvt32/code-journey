package net.dvt32.regexandvalidation.task1;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClassDataPrinterTest {
	
	ClassDataPrinter cdp = new ClassDataPrinter();
	ClassDataPrinter.DataProvider dp = new ClassDataPrinter.DataProvider();
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	
	String[] fieldData = new String[] {
		"public int publicIntegerVariable -> 1",
		"protected double protectedDoubleVariable -> 2.0",
		"private String privateStringVariable -> 3",
		"final long longConstant -> 4",
		"static byte staticByteVariable -> 5",
		"volatile int innerIntegerVariable -> 6",
		"public transient double transientDoubleVariable -> 7.0",
		"public int[] publicIntegerArray -> [8, 9, 10]",
		"protected Double[] protectedDoubleArray -> [11.0, 12.0, 13.0]"	
	};
	
	String[] methodSignatureData = new String[] {
		"methodWithOneParam(int)",
		"methodWithTwoParams(double, double)",
		"methodWithNoParams()",
		"methodWithThreeDifferentParams(int, double, Object)"	
	};
	
	@Before
	public void setUpOutputStream() {
		System.setOut(new PrintStream(consoleOutput));
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}

	/*
	 * printClassInfo() tests
	 */
	@Test
	public void shouldPrintAllFieldsAndMethodSignatures() 
		throws IllegalArgumentException, IllegalAccessException 
	{
		cdp.printClassData(dp);
		String output = consoleOutput.toString();
		
		for (String pieceOfFieldData : fieldData) {
			assertTrue( output.contains(pieceOfFieldData) );
		}
		
		for (String pieceOfMethodSignatureData : methodSignatureData) {
			assertTrue( output.contains(pieceOfMethodSignatureData) );
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() 
		throws IllegalArgumentException, IllegalAccessException 
	{
		cdp.printClassData(null);
	}
	
	/*
	 * printFieldData() tests
	 */
	@Test
	public void shouldPrintOnlyClassFields() 
		throws IllegalArgumentException, IllegalAccessException 
	{		
		cdp.printFieldData(dp);
		String output = consoleOutput.toString();
		
		for (String pieceOfFieldData : fieldData) {
			assertTrue( output.contains(pieceOfFieldData) );
		}

		for (String pieceOfMethodSignatureData : methodSignatureData) {
			assertTrue( !output.contains(pieceOfMethodSignatureData) );
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void printFieldDataMethodShouldThrowNullPointerException() 
		throws IllegalArgumentException, IllegalAccessException 
	{
		cdp.printFieldData(null);
	}
	
	/*
	 * getFieldValue() tests
	 */
	@Test
	public void shouldGetAllFieldValues() 
		throws IllegalArgumentException, IllegalAccessException 
	{
		List<String> expectedValues = Arrays.asList(
			new String[] { "1", "2.0", "3", "4", "5", "6", "7.0", "[8, 9, 10]", "[11.0, 12.0, 13.0]" } 
		);
		List<String> actualValues = new ArrayList<String>();
		
		Field[] fields = dp.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldValue = cdp.getFieldValue(field, dp);
			actualValues.add(fieldValue);
		}
		
		assertTrue( 
			actualValues.containsAll(expectedValues) && 
			actualValues.size() == expectedValues.size() 
		);
	}
	
	@Test(expected = NullPointerException.class)
	public void getFieldValueMethodShouldThrowNullPointerException() 
		throws IllegalArgumentException, IllegalAccessException 
	{
		Field[] fields = dp.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldValue = cdp.getFieldValue(field, null);
		}
	}
	
	/*
	 * printMethodSignatureData() tests
	 */
	@Test
	public void shouldPrintOnlyClassMethodSignatures() 
		throws IllegalArgumentException, IllegalAccessException 
	{		
		cdp.printMethodSignatureData(dp);
		String output = consoleOutput.toString();
		
		for (String pieceOfFieldData : fieldData) {
			assertTrue( !output.contains(pieceOfFieldData) );
		}

		for (String pieceOfMethodSignatureData : methodSignatureData) {
			assertTrue( output.contains(pieceOfMethodSignatureData) );
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void printMethodSignatureDataMethodShouldThrowNullPointerException() 
		throws IllegalArgumentException, IllegalAccessException 
	{
		cdp.printMethodSignatureData(null);
	}	
}
