package net.dvt32.inputoutput.task5;

import java.io.File;

/**
 * This program prints the names of all files and folders
 * inside a particular directory.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class DirectoryBrowser {
	/**
	 * This method accomplishes the program's main task (described above).
	 * If the provided path leads to a file, only an error message is printed.
	 * 
	 * @param path A file path that leads to a certain directory
	 */
	public void listContent(String path) {
		File folder = new File(path);
		boolean pathLeadsToFile = folder.isFile();
		
		if (pathLeadsToFile) {
			System.out.println("The provided path leads to a file!");
		}
		else {
			File[] filesInFolder = folder.listFiles();
			for (File fileInFolder : filesInFolder) {
				if (fileInFolder.isFile()) {
					System.out.println("File: " + fileInFolder.getName());
				}
				else if (fileInFolder.isDirectory()) {
					System.out.println("Directory: " + fileInFolder.getName());
				}
			}
		}
	}
}