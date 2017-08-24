package net.dvt32.inputoutput.task4;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

public class TransferObjectTest {
	
	private final String TEST_DRIVE_PATH = "D:\\";
	
	// Helper method
	public void createFileWithSizeInBytes(int sizeInBytes, String outputFilePath) 
		throws IOException 
	{
		RandomAccessFile file = new RandomAccessFile(outputFilePath, "rw");
		file.setLength(sizeInBytes);
		file.close();
	}
	
	/*
	 * Constructor & getter tests
	 */
	@Test
	public void shouldCreateTransferObjectWithFileInputStreamAndFileOutputStream() 
		throws IOException 
	{
		createFileWithSizeInBytes(100, TEST_DRIVE_PATH + "file1.txt");
		
		FileInputStream fis = new FileInputStream(TEST_DRIVE_PATH + "file1.txt");
		FileOutputStream fos = new FileOutputStream(TEST_DRIVE_PATH + "file2.txt"); 
		TransferObject to = new TransferObject(fis, fos);
		
		assertTrue( to.getInputStream() instanceof FileInputStream );
		assertTrue( to.getOutputStream() instanceof FileOutputStream );
	}
	
	@Test
	public void gettersShouldReturnNull() {
		TransferObject to = new TransferObject(null, null);
		
		assertEquals(null, to.getInputStream());
		assertEquals(null, to.getOutputStream());
	}
	
	/*
	 * transfer() tests
	 */
	@Test
	public void shouldTransferNinetyNineBytes() 
		throws IOException 
	{
		createFileWithSizeInBytes(100, TEST_DRIVE_PATH + "file1.txt");
		
		FileInputStream fis = new FileInputStream(TEST_DRIVE_PATH + "file1.txt");
		FileOutputStream fos = new FileOutputStream(TEST_DRIVE_PATH + "file2.txt"); 
		TransferObject to = new TransferObject(fis, fos);
		
		int expectedResult = 99;
		int actualResult = to.transfer(100, 1);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = IOException.class) 
	public void shouldThrowIOException() 
		throws IOException 
	{
		createFileWithSizeInBytes(100, TEST_DRIVE_PATH + "file1.txt");
		
		FileInputStream fis = new FileInputStream(TEST_DRIVE_PATH + "file1.txt");
		FileOutputStream fos = new FileOutputStream(TEST_DRIVE_PATH + "file2.txt"); 
		TransferObject to = new TransferObject(fis, fos);
		
		to.transfer(100, -1);
	}
	
	@Test
	public void shouldTransferOneByte() 
		throws IOException 
	{
		createFileWithSizeInBytes(1, TEST_DRIVE_PATH + "file1.txt");
		
		FileInputStream fis = new FileInputStream(TEST_DRIVE_PATH + "file1.txt");
		FileOutputStream fos = new FileOutputStream(TEST_DRIVE_PATH + "file2.txt"); 
		TransferObject to = new TransferObject(fis, fos);
		
		int expectedResult = 1;
		int actualResult = to.transfer(100, 0);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void shouldTransferZeroBytesDueToSkippedBytes() throws IOException {
		createFileWithSizeInBytes(10, TEST_DRIVE_PATH + "file1.txt");
		
		FileInputStream fis = new FileInputStream(TEST_DRIVE_PATH + "file1.txt");
		FileOutputStream fos = new FileOutputStream(TEST_DRIVE_PATH + "file2.txt"); 
		TransferObject to = new TransferObject(fis, fos);
		
		int expectedResult = 0;
		int actualResult = to.transfer(1, 10);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void shouldTransferZeroBytesDueToEmptyFile() throws IOException {
		createFileWithSizeInBytes(0, TEST_DRIVE_PATH + "file1.txt");
		
		FileInputStream fis = new FileInputStream(TEST_DRIVE_PATH + "file1.txt");
		FileOutputStream fos = new FileOutputStream(TEST_DRIVE_PATH + "file2.txt"); 
		TransferObject to = new TransferObject(fis, fos);
		
		int expectedResult = 0;
		int actualResult = to.transfer(1, 0);
		assertEquals(expectedResult, actualResult);
	}
}