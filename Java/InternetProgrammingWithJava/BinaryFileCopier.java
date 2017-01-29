// page 27

// modified to be able to generate a binary file beforehand

import java.io.*;

public class BinaryFileCopier {
	
	public static void generateInputFile() throws IOException {
		DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("D:\\input.bin"));
		dataOutputStream.writeChars("The secret of life is...");
		dataOutputStream.close();
	}
	
	public static void main(String[] args) throws IOException {
		generateInputFile();
		
		FileInputStream inputStream = new FileInputStream("D:\\input.bin");
		FileOutputStream outputStream = new FileOutputStream("D:\\output.bin");
		
		byte[] buffer = new byte[1024];
		
		while (true) {
			int bytesRead = inputStream.read(buffer);
			if (bytesRead == -1) { // if end-of-file reached
				break;
			}
			outputStream.write(buffer, 0, bytesRead);
		}
		
		outputStream.flush();
		outputStream.close();
		inputStream.close();
	}
}
