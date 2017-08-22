package net.dvt32.inputoutput.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This program provides a console reader, which can read:
 * - strings ('String' type)
 * - integers ('int' type)
 * - single characters ('char' type)
 * - floating-point numbers ('float' type)
 * 
 * The class uses a BufferedReader internally,
 * in order to provide the reading capabilities.

 * @author Dimitar Trifonov (dvt32)
 */
public class ConsoleReader {
	private BufferedReader bufferedReader;
	
	/**
	 * Constructor, which allows us to create
	 * a console reader from an input stream
	 * such as System.in
	 * 
	 * @param inputStream the input stream used to create a console reader
	 */
	public ConsoleReader(InputStream inputStream) {
		bufferedReader = new BufferedReader( new InputStreamReader(inputStream) );
	}
	
	/**
	 * This method allows the user to read a String.
	 * 
	 * The method throws an exception 
	 * if a problem occurs when reading the String.
	 * 
	 * @param bufferedReader a reader that reads the input String
	 * @return The entered String
	 */
	public String readString(BufferedReader bufferedReader) {
		String input = "";
		
		try {
			input = bufferedReader.readLine();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return input;
	}
	
	/**
	 *  A no parameter version of the readString(BufferedReader) method, 
	 *  which uses the default class BufferedReader object.
	 *  
	 * @return The entered String
	 */
	public String readString() {
		return readString(bufferedReader);
	}
	
	/**
	 * This method allows the user to read an integer.
	 *
	 * The input is read as a String 
	 * and is then converted to an integer.
	 * 
	 * @param bufferedReader a reader that reads the input integer as a String
	 * @return The entered int
	 */
	public int readInteger(BufferedReader bufferedReader) {
		String input = readString(bufferedReader);
		int inputToInteger = Integer.parseInt(input);
		return inputToInteger;
	}
	
	/**
	 *  A no parameter version of the readInteger(BufferedReader) method, 
	 *  which uses the default class BufferedReader object.
	 *  
	 * @return The entered int
	 */
	public int readInteger() {
		return readInteger(bufferedReader);
	}
	
	/**
	 * This method allows the user to read a single character.
	 * 
	 * The input is directly read as a character. 
	 * 
	 * If the user enters more than one character, 
	 * only the first character is taken.
	 * 
	 * @param bufferedReader a reader that reads the input char
	 * @return The entered char
	 */
	public char readChar(BufferedReader bufferedReader) {
		char input = '\0';
		
		try {
			input = (char) bufferedReader.read();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return input;
	}
	
	/**
	 *  A no parameter version of the readChar(BufferedReader) method, 
	 *  which uses the default class BufferedReader object.
	 *  
	 * @return The entered char
	 */
	public int readChar() {
		return readChar(bufferedReader);
	}
	
	/**
	 * This method allows the user to read a floating-point number (float).
	 * 
	 * The input is read as a String
	 * and is then converted to a float.
	 * 
	 * @param bufferedReader a reader that reads the input float as a String
	 * @return The entered float
	 */
	public float readFloat(BufferedReader bufferedReader) {
		String input = readString(bufferedReader);
		float inputToFloat = Float.parseFloat(input);
		return inputToFloat;
	}
	
	/**
	 *  A no parameter version of the readFloat(BufferedReader) method, 
	 *  which uses the default class BufferedReader object.
	 *  
	 * @return The entered float
	 */
	public float readFloat() {
		return readFloat(bufferedReader);
	}
}