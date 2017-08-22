package net.dvt32.inputoutput.task1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class ConsoleReaderTest {
	
	ConsoleReader cr = new ConsoleReader(System.in);

	/*
	 * readString() tests
	 */
	@Test
	public void shouldReturnTurbo() {
		System.setIn( new ByteArrayInputStream("turbo".getBytes()) );
		String expectedResult = "turbo";
		String actualResult = cr.readString( new BufferedReader(new InputStreamReader(System.in)) );
		System.setIn( System.in );
		assertEquals(expectedResult, actualResult);	
	}
	
	@Test
	public void shouldReturnWhiteSpace() {
		System.setIn( new ByteArrayInputStream(" ".getBytes()) );
		String expectedResult = " ";
		String actualResult = cr.readString( new BufferedReader(new InputStreamReader(System.in)) );
		System.setIn( System.in );
		assertEquals(expectedResult, actualResult);	
	}
	
	/*
	 * readInteger() tests
	 */
	@Test
	public void shouldReturn1337() {
		System.setIn( new ByteArrayInputStream("1337".getBytes()) );
		int expectedResult = 1337;
		int actualResult = cr.readInteger( new BufferedReader(new InputStreamReader(System.in)) );
		System.setIn( System.in );
		assertEquals(expectedResult, actualResult);	
	}
	
	@Test
	public void shouldReturnMinusOne() {
		System.setIn( new ByteArrayInputStream("-1".getBytes()) );
		int expectedResult = -1;
		int actualResult = cr.readInteger( new BufferedReader(new InputStreamReader(System.in)) );
		System.setIn( System.in );
		assertEquals(expectedResult, actualResult);	
	}
	
	/*
	 * readChar() tests
	 */
	@Test
	public void shouldReturnC() {
		System.setIn( new ByteArrayInputStream("c".getBytes()) );
		char expectedResult = 'c';
		char actualResult = cr.readChar( new BufferedReader(new InputStreamReader(System.in)) );
		System.setIn( System.in );
		assertEquals(expectedResult, actualResult);	
	}
	
	@Test
	public void shouldReturnNullChar() {
		System.setIn( new ByteArrayInputStream("\0".getBytes()) );
		char expectedResult = '\0';
		char actualResult = cr.readChar( new BufferedReader(new InputStreamReader(System.in)) );
		System.setIn( System.in );
		assertEquals(expectedResult, actualResult);	
	}
	
	@Test
	public void shouldReturnWhitespaceChar() {
		System.setIn( new ByteArrayInputStream(" ".getBytes()) );
		char expectedResult = ' ';
		char actualResult = cr.readChar( new BufferedReader(new InputStreamReader(System.in)) );
		System.setIn( System.in );
		assertEquals(expectedResult, actualResult);	
	}
	
	@Test
	public void shouldReturnD() {
		System.setIn( new ByteArrayInputStream("D and some random chars that are ignored".getBytes()) );
		char expectedResult = 'D';
		char actualResult = cr.readChar( new BufferedReader(new InputStreamReader(System.in)) );
		System.setIn( System.in );
		assertEquals(expectedResult, actualResult);	
	}
	
	/*
	 * readFloat() tests
	 */
	public void shouldReturnPi() {
		System.setIn( new ByteArrayInputStream("3.14".getBytes()) );
		float expectedResult = 3.14f;
		float actualResult = cr.readFloat( new BufferedReader(new InputStreamReader(System.in)) );
		System.setIn( System.in );
		assertEquals(expectedResult, actualResult, 0.001);	
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException() {
		System.setIn( new ByteArrayInputStream("3,14".getBytes()) );
		try {
			float result = cr.readFloat( new BufferedReader(new InputStreamReader(System.in)) );
		}
		finally {
			System.setIn( System.in );
		}
	}
}