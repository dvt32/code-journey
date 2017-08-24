package net.dvt32.inputoutput.task4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This program transfers the contents of an InputStream instance to an OutputStream instance.
 * 
 * A buffer is used when transferring the information. 
 * Its size can be altered by changing the BUFFER_SIZE constant's value.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class TransferObject {
	private InputStream inputStream;
	private OutputStream outputStream;
	private final int BUFFER_SIZE = 1024;
	
	/**
	 * Constructor, which initializes the input and output streams.
	 * 
	 * @param inputStream The InputStream instance
	 * @param outputStream The OutputStream instance
	 */
	public TransferObject(InputStream inputStream, OutputStream outputStream) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}
	
	/*
	 * Getter methods
	 */
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public OutputStream getOutputStream() {
		return outputStream;
	}
	
	/**
	 * This method reads the contents of the class' InputStream instance
	 * and transfers 'numberOfBytes' number of bytes from it
	 * to the class' OutputStream instance.
	 * 
	 * Before the reading begins, 'offset' number of bytes 
	 * are skipped from the class' InputStream instance.
	 * 
	 * In the case that the InputStream instance 
	 * has less than the desired number of bytes,
	 * the actual number of bytes transfered will be equal to
	 * the total number of bytes in the InputStream instance 
	 * minus the 'offset' number of skipped bytes.
	 * 
	 * @param numberOfBytes 
	 * 		The number of bytes to transfer 
	 * 		from the InputStream instance 
	 * 		to the OutputStream instance (if possible)
	 * @param offset 
	 * 		The number of bytes to skip 
	 * 		before starting to read from the InputStream instance
	 * @return The number of actually transferred bytes
	 */
	public int transfer(int numberOfBytes, int offset) 
		throws IOException 
	{
		InputStream inputStream = getInputStream();
		OutputStream outputStream = getOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		int readBytesCount;
		int transferredBytesCount = 0;
		
		inputStream.skip(offset);
		
		while (
			   (transferredBytesCount < numberOfBytes) && 
			   (readBytesCount = inputStream.read(buffer)) != -1
			  ) 
		{
			outputStream.write(buffer, 0, readBytesCount);
			transferredBytesCount += readBytesCount;
		}
		
		return transferredBytesCount;
	}
}