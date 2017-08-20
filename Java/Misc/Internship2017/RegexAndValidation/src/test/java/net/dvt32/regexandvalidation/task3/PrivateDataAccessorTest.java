package net.dvt32.regexandvalidation.task3;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrivateDataAccessorTest {
	
	PrivateDataAccessor dataAccessor = new PrivateDataAccessor();
	PrivateDataProvider dataProvider = new PrivateDataProvider();
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	
	@Before
	public void setUpOutputStream() {
		System.setOut(new PrintStream(consoleOutput));
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}
	
	String[] privateFieldNamesAndValues = new String[] {
		"privateIntVariable -> 1", 
		"privateIntArray -> [2, 3, 4, 5]", 
		"privateDoubleObject -> 6.0", 
		"privateDoubleObjectArray -> [7.0, 8.0]"
	};
	
	String[] privateMethodsWithNoParametersNamesAndReturnValues = new String[] {
		"privateIntegerArrayMethod()", 
		" -> Returns: [16, 17, 18, 19, 20]", 
		"privateVoidMethod()", 
		" -> No returned value!", 
		"10", 
		"privateIntArrayMethod()", 
		" -> Returns: [11, 12, 13, 14, 15]", 
		"privateIntegerMethod()", 
		" -> Returns: 9"
	};

	/*
	 * printAllPrivateFieldNamesAndValues() tests
	 */
	@Test
	public void shouldPrintAllPrivateFieldNamesAndValues() 
		throws IllegalArgumentException, IllegalAccessException 
	{
		dataAccessor.printAllPrivateFieldNamesAndValues(dataProvider);
		String output = consoleOutput.toString();
		
		for (String privateFieldNameAndValue : privateFieldNamesAndValues) {
			assertTrue( output.contains(privateFieldNameAndValue) );
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() 
		throws IllegalArgumentException, IllegalAccessException 
	{
		dataAccessor.printAllPrivateFieldNamesAndValues(null);
	}
	
	/*
	 * getFieldValue() tests
	 */
	@Test
	public void shouldGetAllFieldValuesIncludingNonPrivateOnes() 
		throws IllegalArgumentException, IllegalAccessException 
	{
		List<String> expectedValues = Arrays.asList(
			new String[] { "1", "[2, 3, 4, 5]", "6.0", "[7.0, 8.0]", "21" } 
		);
		List<String> actualValues = new ArrayList<String>();
		
		Field[] fields = dataProvider.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldValue = dataAccessor.getFieldValue(field, dataProvider);
			actualValues.add( fieldValue );
		}
		
		assertTrue( 
			actualValues.containsAll(expectedValues) && 
			actualValues.size() == expectedValues.size() 
		);
	}
	
	@Test(expected = IllegalAccessException.class)
	public void shouldThrowIllegalAccessException() 
		throws IllegalArgumentException, IllegalAccessException 
	{
		Field[] fields = dataProvider.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldValue = dataAccessor.getFieldValue(field, dataProvider); // can't get private fields
		}
	}
	
	@Test
	public void shouldPrintValueOfPrivateField() 
		throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException 
	{
		Field field = dataProvider.getClass().getDeclaredField("privateIntVariable");
		field.setAccessible(true);
		
		String expectedFieldValue = "1";
		String actualFieldValue = dataAccessor.getFieldValue(field, dataProvider);
		assertEquals(expectedFieldValue, actualFieldValue);
	}
	
	/*
	 * printAllPrivateNoParamMethodsNamesAndReturnValues() tests
	 */
	@Test
	public void shouldPrintAllPrivateMethodsWithoutParametersReturnValues() 
		throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		dataAccessor.printAllPrivateNoParamMethodsNamesAndReturnValues(dataProvider);
		String output = consoleOutput.toString();
		
		/*
		 *  The reason for testing via contains() is that 
		 *  Method does not guarantee a certain order when getting the methods.
		 */
		for (String privateMethodWithNoParametersNameAndReturnValue : privateMethodsWithNoParametersNamesAndReturnValues) {
			assertTrue( 
				output.contains(privateMethodWithNoParametersNameAndReturnValue)
			);
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void printMethodDataMethodShouldThrowNullPointerException() 
		throws IllegalArgumentException, IllegalAccessException, InvocationTargetException 
	{
		dataAccessor.printAllPrivateNoParamMethodsNamesAndReturnValues(null);
	}
	
	
	/*
	 * getMethodReturnValue() tests
	 */
	@Test(expected = NoSuchMethodException.class)
	public void shouldThrowNoSuchMethodException() 
		throws NoSuchMethodException, SecurityException 
	{
		Method method = dataProvider.getClass().getDeclaredMethod("nonExistingMethod");
	}
	
	@Test
	public void shouldGetMethodsReturnValues() 
		throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		Method firstMethod = dataProvider.getClass().getDeclaredMethod("privateIntegerMethod");
		firstMethod.setAccessible(true);
		String expectedFirstMethodReturnValue = "9";
		String actualFirstMethodReturnValue = dataAccessor.getMethodReturnValue(firstMethod, dataProvider);
		assertEquals(expectedFirstMethodReturnValue, actualFirstMethodReturnValue);
		
		Method secondMethod = dataProvider.getClass().getDeclaredMethod("privateVoidMethod");
		secondMethod.setAccessible(true);
		String expectedSecondMethodReturnValue = "void";
		String actualSecondMethodReturnValue = dataAccessor.getMethodReturnValue(secondMethod, dataProvider);
		assertEquals(expectedSecondMethodReturnValue, actualSecondMethodReturnValue);
	}
}