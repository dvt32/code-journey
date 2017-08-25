package net.dvt32.inputoutput.task6;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import net.dvt32.inputoutput.task6.DataClass.UserDefinedObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataClassTest {

	DataClass dc = new DataClass();
	private final String TEST_DRIVE_PATH = "D:\\";
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	
	@Before
	public void setUpOutputStream() {
		System.setOut( new PrintStream(consoleOutput) );
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut( null );
	}
	
	/*
	 * saveObject() tests
	 */
	@Test
	public void shouldSerializeObjectSuccessfully() 
		throws IOException, ClassNotFoundException 
	{
		final String FILE_NAME = "outputFile";
		UserDefinedObject objectToSerialize = new UserDefinedObject(1, "John");

		dc.saveObject(TEST_DRIVE_PATH + FILE_NAME, objectToSerialize);
		
		String output = consoleOutput.toString();
		assertTrue( 
			output.equals( "Object successfully serialized!" + System.getProperty("line.separator") ) 
		);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() 
		throws IOException 
	{
		UserDefinedObject objectToSerialize = new UserDefinedObject(1, "John");
		dc.saveObject(null, objectToSerialize);
	}
	
	@Test(expected = FileNotFoundException.class)
	public void shouldThrowFileNotFoundException() throws IOException {
		dc.saveObject("", null);
	}
	
	/*
	 * getObject() tests
	 */
	@Test
	public void shouldDeserializeObjectSuccessfully() 
		throws ClassNotFoundException, IOException
	{
		final String FILE_NAME = "outputFile";
		
		UserDefinedObject deserializedObject = (UserDefinedObject) dc.getObject(TEST_DRIVE_PATH + FILE_NAME);
		
		String output = consoleOutput.toString();
		assertTrue( 
			output.equals( "Object successfully deserialized!" + System.getProperty("line.separator") ) 
		);
		
		assertEquals( 1, deserializedObject.getId() );
		assertEquals( "John", deserializedObject.getName() );
	}
	
	@Test(expected = FileNotFoundException.class)
	public void deserializeMethodShouldThrowFileNotFoundException() 
		throws IOException, ClassNotFoundException 
	{
		dc.getObject("");
	}
	
	@Test(expected = NullPointerException.class)
	public void deserializeMethodShouldThrowNullPointerException() 
		throws IOException, ClassNotFoundException 
	{
		dc.getObject(null);
	}
}