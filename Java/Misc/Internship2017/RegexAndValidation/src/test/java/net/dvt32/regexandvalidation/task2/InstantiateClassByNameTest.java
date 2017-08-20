package net.dvt32.regexandvalidation.task2;

import static org.junit.Assert.*;

import org.junit.Test;

public class InstantiateClassByNameTest {

	InstantiateClassByName icbn = new InstantiateClassByName();
	
	/*
	 * getNewObjectFromClass() tests
	 */
	@Test
	public void shouldCreateNewStringBuilderObject() 
		throws ClassNotFoundException, IllegalAccessException, InstantiationException 
	{
		Object stringBuilder = icbn.getNewObjectFromClass("java.lang.StringBuilder");
		assertTrue( stringBuilder instanceof StringBuilder );
		
		((StringBuilder) stringBuilder).append("hello");
		assertTrue( stringBuilder.toString().equals("hello") );
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() 
		throws ClassNotFoundException, IllegalAccessException, InstantiationException 
	{
		Object stringBuilder = icbn.getNewObjectFromClass(null);
	}
	
	@Test
	public void shouldReturnNullBecauseThereIsNoPublicParameterlessConstructor() 
		throws ClassNotFoundException, IllegalAccessException, InstantiationException 
	{
		Object object = icbn.getNewObjectFromClass("java.lang.System");
		assertTrue( !(object instanceof System) );
		assertTrue( object == null );
	}
	
	/*
	 * getNameOfSuperclassOfClass() tests
	 */
	@Test
	public void shouldReturnAbstractStringBuilderClassName() 
		throws ClassNotFoundException 
	{
		String expectedResult = "java.lang.AbstractStringBuilder";
		String actualResult = icbn.getNameOfSuperclassOfClass("java.lang.StringBuilder");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = NullPointerException.class)
	public void getSuperclassNameMethodShouldThrowNullPointerException() 
		throws ClassNotFoundException 
	{
		icbn.getNameOfSuperclassOfClass("java.lang.Object");
	}
	
	@Test
	public void shouldReturnObjectClassName() 
		throws ClassNotFoundException 
	{
		String expectedResult = "java.lang.Object";
		String actualResult = icbn.getNameOfSuperclassOfClass("java.lang.String");
		assertEquals(expectedResult, actualResult);
	}
	
	/*
	 * getNamesOfInterfacesImplementedByClass()
	 */
	@Test
	public void shouldReturnSerializableAndCharSequenceInterfaceNames() 
		throws ClassNotFoundException 
	{
		String expectedResult = "java.io.Serializable, java.lang.CharSequence";
		String actualResult = String.join(
			", ",
			icbn.getNamesOfInterfacesImplementedByClass("java.lang.StringBuilder")
		);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void shouldReturnNoInterfaces() 
		throws ClassNotFoundException 
	{
		String expectedResult = "";
		String actualResult = String.join(
			", ",
			icbn.getNamesOfInterfacesImplementedByClass("java.lang.Object")
		);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = NullPointerException.class)
	public void getInterfaceNamesMethodShouldThrowNullPointerException() 
		throws ClassNotFoundException 
	{
		icbn.getNamesOfInterfacesImplementedByClass(null);
	}
}